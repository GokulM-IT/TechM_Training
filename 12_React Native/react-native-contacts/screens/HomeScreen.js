import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, Button, FlatList } from 'react-native';
import * as Contacts from 'expo-contacts';

export default function HomeScreen({ navigation }) {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    const loadContacts = async () => {
      const { status } = await Contacts.requestPermissionsAsync();
      if (status === 'granted') {
        const { data } = await Contacts.getContactsAsync();
        setContacts(data);
      }
    };
    loadContacts();
  }, []);

  return (
    <View style={styles.container}>
      <Button title="Add Contact" onPress={() => navigation.navigate('Add Contact')} />
      <FlatList
        data={contacts}
        keyExtractor={(item) => item.id}
        renderItem={({ item }) => (
          <View style={styles.contactItem}>
            <Text style={styles.name}>{item.name}</Text>
            {item.phoneNumbers && <Text>{item.phoneNumbers[0]?.number}</Text>}
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
  },
  contactItem: {
    padding: 10,
    borderBottomWidth: 1,
    borderBottomColor: '#ccc',
  },
  name: {
    fontSize: 18,
    fontWeight: 'bold',
  },
});