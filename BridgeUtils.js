import { NativeModules } from "react-native"

const { CustomModule } = NativeModules;

export const startNativeActivity = () => {
    const mesagge = "Test ssss";
    CustomModule.startActivity(mesagge);
};