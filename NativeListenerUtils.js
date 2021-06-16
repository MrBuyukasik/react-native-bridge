import { NativeModules, NativeEventEmitter } from "react-native"

const { CustomModule } = NativeModules;
const CustomEmitter = new NativeEventEmitter(CustomModule);

class NativeModuleListener {
    static addActionListener = (listenerType, callback) => {
        CustomEmitter.addListener(listenerType, info => {
            if (callback) {
                callback(info)
            }
        })
    }
}

export default NativeModuleListener