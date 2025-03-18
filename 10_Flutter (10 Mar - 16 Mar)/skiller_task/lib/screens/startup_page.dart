import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

class StartupPage extends StatefulWidget {
  const StartupPage({super.key});

  @override
  State<StartupPage> createState() => _StartupPageState();
}

class _StartupPageState extends State<StartupPage> {
  // Mark that the user has seen the startup page and safely navigate.
  Future<void> _completeStartup() async {
    final prefs = await SharedPreferences.getInstance();
    if (!mounted) return;

    await prefs.setBool('hasSeenStartup', true);
    if (!mounted) return;

    Navigator.pushReplacementNamed(context, '/auth');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        centerTitle: true,
        backgroundColor: Colors.pink.shade50,
        elevation: 0,
        title: const Text(
          'Skiller',
          style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold),
        ),
      ),
      // Use a container with your app's gradient background.
      body: Container(
        width: double.infinity,
        decoration: BoxDecoration(
          gradient: LinearGradient(
            colors: [Colors.pink.shade50, Colors.white],
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
          ),
        ),
        child: SafeArea(
          child: Column(
            children: [
              // Top Section: Motivational Texts
              Padding(
                padding: const EdgeInsets.symmetric(
                  horizontal: 32,
                  vertical: 50,
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    // Add extra spacing so that "PUSH" is pushed further down from the app bar.
                    const SizedBox(height: 40),
                    // Two-line text with custom font (replace 'RobotoSlab' with your chosen font).
                    Text(
                      'PUSH',
                      style: TextStyle(
                        fontSize: 24,
                        fontWeight: FontWeight.w400,
                        color: Colors.black87,
                        fontFamily:
                            'RobotoSlab', // Ensure this font is declared in your pubspec.yaml
                      ),
                    ),
                    Text(
                      'YOURSELF',
                      style: TextStyle(
                        fontSize: 40,
                        fontWeight: FontWeight.bold,
                        color: Colors.black,
                        letterSpacing: 1.2,
                        fontFamily: 'RobotoSlab', // Use the same custom font
                      ),
                    ),
                    const SizedBox(height: 60),
                    // "Let's Start" button.
                    ElevatedButton(
                      onPressed: _completeStartup,
                      style: ElevatedButton.styleFrom(
                        padding: const EdgeInsets.symmetric(
                          vertical: 16,
                          horizontal: 32,
                        ),
                        backgroundColor: Colors.black,
                        shape: RoundedRectangleBorder(
                          borderRadius: BorderRadius.circular(24),
                        ),
                      ),
                      child: const Text(
                        'Let\'s Start',
                        style: TextStyle(
                          fontSize: 20,
                          fontWeight: FontWeight.bold,
                          letterSpacing: 1.1,
                          color: Colors.white,
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              // Bottom Section: Image covering remaining space
              Expanded(
                child: Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Center(
                    child: Image.asset(
                      'lib/assets/Startup_Image.png',
                      fit: BoxFit.contain,
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
