import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'localization.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Locale _locale = Locale('en');

  void _changeLocale(Locale locale) {
    setState(() {
      _locale = locale;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter i18n Example',
      locale: _locale,
      localizationsDelegates: [
        AppLocalizations.delegate,
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
      ],
      supportedLocales: [
        const Locale('en', ''),
        const Locale('es', ''),
        const Locale('fr', ''),
        const Locale('ta', ''),
        const Locale('te', ''),
        const Locale('hi', ''),
        const Locale('kn', ''),
        const Locale('ml', ''),
        const Locale('bn', ''),
      ],
      home: HomePage(onLocaleChange: _changeLocale),
    );
  }
}

class HomePage extends StatelessWidget {
  final Function(Locale) onLocaleChange;

  const HomePage({super.key, required this.onLocaleChange});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(AppLocalizations.of(context).translate('title')),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(AppLocalizations.of(context).translate('message')),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('en'));
              },
              child: Text('English'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('es'));
              },
              child: Text('Español'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('fr'));
              },
              child: Text('Francas'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('ta'));
              },
              child: Text('தமிழ்'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('te'));
              },
              child: Text('తెలుగు'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('hi'));
              },
              child: Text('हिन्दी'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('kn'));
              },
              child: Text('ಕನ್ನಡ'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('ml'));
              },
              child: Text('മലയാളം'),
            ),
            ElevatedButton(
              onPressed: () {
                onLocaleChange(Locale('bn'));
              },
              child: Text('বাংলা'),
            ),
          ],
        ),
      ),
    );
  }
}
