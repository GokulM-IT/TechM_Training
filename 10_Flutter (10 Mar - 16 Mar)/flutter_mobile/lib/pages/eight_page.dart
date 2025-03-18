import 'package:flutter/material.dart';
import 'package:http/io_client.dart';
import 'dart:convert';
import 'dart:io';
import 'dart:async';

class EightPage extends StatefulWidget {
  const EightPage({super.key});
  @override
  State<EightPage> createState() => _EightPageState();
}

class _EightPageState extends State<EightPage> {
  String _quote = '';
  String _author = '';
  Timer? _timer;

  @override
  void initState() {
    super.initState();
    _fetchQuote();
    _timer = Timer.periodic(Duration(seconds: 15), (Timer t) => _fetchQuote());
  }

  @override
  void dispose() {
    _timer?.cancel();
    super.dispose();
  }

  Future<void> _fetchQuote() async {
    final httpClient =
        HttpClient()
          ..badCertificateCallback =
              (X509Certificate cert, String host, int port) => true;
    final ioClient = IOClient(httpClient);

    final response = await ioClient.get(
      Uri.parse('http://13.90.102.109:3000/api/random'),
    );
    if (response.statusCode == 200) {
      final data = jsonDecode(response.body);
      setState(() {
        _quote = data['content'];
        _author = data['author'];
      });
    } else {
      throw Exception('Failed to load quote');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Eight Page - Random Quote'),
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: <Widget>[
            if (_quote.isNotEmpty) ...[
              Text(
                _quote,
                style: TextStyle(fontSize: 24, fontStyle: FontStyle.italic),
                textAlign: TextAlign.center,
              ),
              SizedBox(height: 10),
              Text(
                '- $_author',
                style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                textAlign: TextAlign.right,
              ),
            ],
            SizedBox(height: 20),
            ElevatedButton(onPressed: _fetchQuote, child: Text('Change Quote')),
          ],
        ),
      ),
    );
  }
}
