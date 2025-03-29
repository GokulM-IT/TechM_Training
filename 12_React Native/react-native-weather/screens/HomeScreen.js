import React, { useState } from 'react';
import { View, Button, FlatList, Text, TouchableOpacity, StyleSheet } from 'react-native';

const cities = ['London', 'Paris', 'New York', 'Tokyo', 'Sydney'];

const HomeScreen = ({ navigation }) => {
  const [selectedCity, setSelectedCity] = useState('');

  const handleCitySelection = (city) => {
    setSelectedCity(city);
    navigation.navigate('Weather', { city });
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Select a City:</Text>
      <FlatList
        data={cities}
        keyExtractor={(item) => item}
        renderItem={({ item }) => (
          <TouchableOpacity
            style={styles.cityButton}
            onPress={() => handleCitySelection(item)}
          >
            <Text style={styles.cityText}>{item}</Text>
          </TouchableOpacity>
        )}
      />

    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  title: {
    fontSize: 20,
    marginBottom: 20,
  },
  cityButton: {
    padding: 10,
    backgroundColor: '#ddd',
    marginVertical: 5,
  },
  cityText: {
    fontSize: 18,
  },
});

export default HomeScreen;