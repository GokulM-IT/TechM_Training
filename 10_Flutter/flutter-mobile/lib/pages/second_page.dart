import 'package:flutter/material.dart';
import '../widgets/countdown.dart';

class SecondPage extends StatelessWidget {
  const SecondPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Second Page'),
        backgroundColor: const Color.fromARGB(255, 0, 0, 0),
        foregroundColor: Colors.white,
      ),
      body: Center(
        child: Padding(padding: const EdgeInsets.all(16.0), child: CountDown()),
      ),
    );
  }
}
