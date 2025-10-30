const os = require("os");
const fs = require("fs");
const path = require("path");
const https = require("https");
const http = require("http");
const axios = require("axios");

class Utils {

	static minecraftDirectory;
	static legacyDirectory;
	static librariesDirectory;
	static versionsDirectory;
	static assetsDirectory;
	static assetObjectsDirectory;
	static assetIndexesDirectory;
	static gameDirectory;
	static serversFile;
	static version = require("./package.json").version;
	static configFile;
	static latestLog;

	static init() {
		Utils.minecraftDirectory = os.homedir();
		Utils.legacyDirectory = os.homedir();
		switch (process.platform) {
			case "linux":
				Utils.minecraftDirectory += "/.config/Aura Client 2";
				Utils.legacyDirectory += "/.config/parrotclient";
				break;
			case "osx":
				Utils.minecraftDirectory += "/Library/Application Support/Aura Client 2";
				Utils.legacyDirectory += "/Library/Application Support/parrotclient";
				break;
			case "windows":
				Utils.minecraftDirectory += "/AppData/Roaming/Aura Client 2";
				Utils.legacyDirectory += "/AppData/Roaming/parrotclient";
				break;
		}

		try {
			if(fs.existsSync(Utils.legacyDirectory) && !fs.existsSync(Utils.minecraftDirectory)) {
				fs.renameSync(Utils.legacyDirectory, Utils.minecraftDirectory);
				fs.unlinkSync(Utils.minecraftDirectory + "/account.json");
			}
		}
		catch(error) {
		}

		Utils.librariesDirectory = Utils.minecraftDirectory + "/libraries";
		Utils.versionsDirectory = Utils.minecraftDirectory + "/versions";
		Utils.assetsDirectory = Utils.minecraftDirectory + "/assets";
		Utils.assetObjectsDirectory = Utils.assetsDirectory + "/objects";
		Utils.assetIndexesDirectory = Utils.assetsDirectory + "/indexes";
		Utils.accountFile = Utils.minecraftDirectory + "/account.json";
		Utils.gameDirectory = Utils.minecraftDirectory + "/minecraft";

		if(!fs.existsSync(Utils.gameDirectory)) {
			fs.mkdirSync(Utils.gameDirectory, { recursive: true });
		}
	}

	static isAlreadyDownloaded(file, size) {
		return fs.existsSync(file) && (size == -1 || fs.statSync(file).size == size);
	}

	static download(url, file, size) {
		if(!fs.existsSync(path.dirname(file))) {
			fs.mkdirSync(path.dirname(file), { recursive: true });
		}

		if(!Utils.isAlreadyDownloaded(file, size)) {
			return new Promise((resolve, reject) => {
				(url.startsWith("https://") ? https : http).get(url, async(response, error) => {
					if(error) {
						reject(error);
						return;
					}

					if(response.code == 404) {
						reject(new Error("Server responded with error 404"));
						return;
					}

					if(response.headers.location) {
						var result = await Utils.download(response.headers.location, file, size);
						resolve(result);
						return;
					}
					var stream = fs.createWriteStream(file);
					response.pipe(stream);
					response.on("end", () => {
						stream.close();
						resolve(true);
					});
				});
			});
		}
		return new Promise((resolve) => resolve(true));
	}

	static getOptiFine(version) {
		return new Promise((resolve) => {
			axios.get("https://optifine.net/adloadx?f=OptiFine_" + version + ".jar")
				.then((response) => {
					var link = "https://optifine.net/downloadx?f=" +
							response.data.substring(response.data
									.indexOf("<a href='downloadx?f=")
									 		+ "<a href='downloadx?f=".length, response.data.indexOf("' onclick='onDownload()'>"))
					resolve(link);
				});
		});
	}

	static getOsName() {
		switch(os.type()) {
			case "Linux":
				return "linux";
			case "Darwin":
				return "osx";
			case "Windows_NT":
				return "windows";
		}
	}

	static getJdkOsName() {
		switch(os.type()) {
			case "Linux":
				return "linux";
			case "Darwin":
				return "mac";
			case "Windows_NT":
				return "windows";
		}
	}

}

module.exports = Utils;
