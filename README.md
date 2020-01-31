# Sumokoin Android Wallet

### QUICKSTART
- Download the APK for the most current release [here](https://link.to.be.inserted) and install it
- Run the App and select "Generate Wallet" to create a new wallet or recover a wallet
- Advanced users can copy over synced wallet files (all files) onto sdcard in directory sumowallet (created first time App is started)
- See the [FAQ](doc/FAQ.md)

### Disclaimer
You may lose all your Sumo if you use this App incorrectly. Be cautious when spending on the mainnet.

### Issues / Pitfalls
- Users of Zenfone MAX & Zenfone 2 Laser (possibly others) **MUST** use the armeabi-v7a APK as the arm64-v8a build uses hardware AES
functionality these models don't have.
- You should backup your wallet files in the "sumowallet" folder periodically.
- Also note, that on some devices the backups will only be visible on a PC over USB after a reboot of the device (it's an Android bug/feature)
- Created wallets on a private testnet are unusable because the restore height is set to that
of the "real" testnet.  After creating a new wallet, make a **new** one by recovering from the seed.
The official sumokoin client shows the same behaviour.

### HOW TO BUILD

See [the instructions](doc/BUILDING-external-libs.md)

Then, fire up Android Studio and build the APK.
