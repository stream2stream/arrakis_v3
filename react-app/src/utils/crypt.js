import sha256 from 'crypto-js/sha256';
import hmacSHA512 from 'crypto-js/hmac-sha512';
import Base64 from 'crypto-js/enc-base64';
import CryptoJS from 'crypto-js';

class Crypt {
    //~Vars/Fields
    static encryptedBase64Key;

    constructor() {
        //Get and update from java server side logic
        encryptedBase64Key = "bXVzdGJlMTZieXRlc2tleQ==";
    } 

    //~functions
    encryptStr(plainText) {
        console.log("Encrypting: " + plainText);

        //Encryption
        let parsedBase64Key = CryptoJS.enc.Base64.parse(encryptedBase64Key);
        let encryptedData = CryptoJS.AES.encrypt(plainText, parsedBase64Key, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
        });

        console.log("encryptedData: " + encryptedData );

        return encryptedData;
    }

    descryptStr(encryptedText) {
        console.log("Decrypting: " + encryptedText);

        //Decryption
        let parsedBase64Key = CryptoJS.enc.Base64.parse(encryptedBase64Key);
        let decryptedData = CryptoJS.AES.decrypt(encryptedText, parsedBase64Key, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7
        } );
        // Decrypted data
        console.log("decryptedData: " + decryptedData);

        // Decrypted data as a string
        var decryptedText = decryptedData.toString( CryptoJS.enc.Utf8 );
        console.log("decryptedText: " + decryptedText);

        return decryptedText;
    }
};

// const CryptLogic = {
//     c: new Crypt()
// } 
const CryptLogic = new Crypt();

export default CryptLogic;
