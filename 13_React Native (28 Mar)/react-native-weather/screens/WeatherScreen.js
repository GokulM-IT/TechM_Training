import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet } from 'react-native';

const WeatherScreen = ({ route }) => {
  const { city } = route.params;
  const [weatherData, setWeatherData] = useState(null);

  useEffect(() => {
    fetch(
      `http://api.openweathermap.org/data/2.5/weather?q=${city}&appid=your_api_key_here&units=metric`
    )
      .then((response) => response.json())
      .then((data) => setWeatherData(data))
      .catch((error) => console.error(error));
  }, [city]);

  return (
    <View style={styles.container}>
      {weatherData ? (
        <>
          <Text style={styles.title}>Weather in {weatherData.name}</Text>
          <Text style={styles.info}>
            Temperature: {weatherData.main.temp}°C
          </Text>
          <Text style={styles.info}>
            Condition: {weatherData.weather[0].description}
          </Text>
          <Text style={styles.info}>
            Humidity: {weatherData.main.humidity}%
          </Text>
          <Text style={styles.info}>
            Wind Speed: {weatherData.wind.speed} m/s
          </Text>
        </>
      ) : (
        <Text style={styles.loading}>Loading weather data...</Text>
      )}
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
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
  },
  info: {
    fontSize: 18,
  },
  loading: {
    fontSize: 16,
    fontStyle: 'italic',
  },
});

export default WeatherScreen;