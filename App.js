import React, {useEffect, useState} from 'react';
import {View, Button, Alert, Text} from 'react-native';
import {startNativeActivity} from './BridgeUtils';
import NativeModuleListener from './NativeListenerUtils';

const handleNavigateToNativeSide = () => {
  startNativeActivity();
};

const App = () => {
  const [nativeMessage, setNativeMessage] = useState();

  const handleNativeData = info => {
    if (info) {
      setNativeMessage(info?.nativeMessage);
    }
  };

  useEffect(() => {
    const customEmitter = NativeModuleListener.addActionListener(
      'dataCallback',
      handleNativeData,
    );
  });

  return (
    <View style={{flex: 1, justifyContent: 'center', marginHorizontal: 20}}>
      {nativeMessage && <Text>{nativeMessage}</Text>}
      <Button
        onPress={() => handleNavigateToNativeSide()}
        title={'navigate to native side'}
      />
    </View>
  );
};

export default App;
