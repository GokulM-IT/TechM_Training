import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(title: 'Firestore Example', home: FirestoreApp());
  }
}

class FirestoreApp extends StatefulWidget {
  const FirestoreApp({super.key});

  @override
  State<FirestoreApp> createState() => _FirestoreAppState();
}

class _FirestoreAppState extends State<FirestoreApp> {
  final TextEditingController _nameController = TextEditingController();
  final TextEditingController _ageController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Firestore Example')),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _nameController,
              decoration: InputDecoration(labelText: 'Name'),
            ),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _ageController,
              decoration: InputDecoration(labelText: 'Age'),
              keyboardType: TextInputType.number,
            ),
          ),
          ElevatedButton(
            onPressed: () {
              final String name = _nameController.text;
              final int age = int.parse(_ageController.text);

              FirebaseFirestore.instance.collection('users').add({
                'name': name,
                'age': age,
              });

              _nameController.clear();
              _ageController.clear();
            },
            child: Text('Add User'),
          ),
          Expanded(
            child: StreamBuilder(
              stream:
                  FirebaseFirestore.instance.collection('users').snapshots(),
              builder: (context, AsyncSnapshot<QuerySnapshot> snapshot) {
                if (!snapshot.hasData) {
                  return Center(child: CircularProgressIndicator());
                }

                return ListView.builder(
                  itemCount: snapshot.data?.docs.length,
                  itemBuilder: (context, index) {
                    final DocumentSnapshot user = snapshot.data!.docs[index];
                    return ListTile(
                      title: Text(user['name']),
                      subtitle: Text('Age: ${user['age']}'),
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
