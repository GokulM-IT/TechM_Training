import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:provider/provider.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'screens/login_screen.dart';
import 'screens/register_screen.dart';
import 'screens/navigation_bar_screen.dart';
import 'screens/startup_page.dart'; // Import the StartupPage
import 'providers/course_provider.dart';
import 'providers/favorite_provider.dart';
import 'localization/app_localizations.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  // Allows child widgets to update the locale.
  static void setLocale(BuildContext context, Locale newLocale) {
    _MyAppState? state = context.findAncestorStateOfType<_MyAppState>();
    state?.setLocale(newLocale);
  }

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  Locale _locale = const Locale('en');

  void setLocale(Locale newLocale) {
    if (_locale != newLocale) {
      setState(() {
        _locale = newLocale;
      });
    }
  }

  /// Checks whether the startup page has been seen.
  Future<bool> _checkStartupSeen() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getBool('hasSeenStartup') ?? false;
  }

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => CourseProvider()),
        ChangeNotifierProvider(create: (_) => FavoriteProvider()),
      ],
      child: MaterialApp(
        title: 'SkillUp',
        theme: ThemeData(primarySwatch: Colors.blue),
        debugShowCheckedModeBanner: false,
        locale: _locale,
        supportedLocales: const [Locale('en'), Locale('ta')],
        localizationsDelegates: [
          AppLocalizations.delegate,
          GlobalMaterialLocalizations.delegate,
          GlobalWidgetsLocalizations.delegate,
        ],
        home: FutureBuilder<bool>(
          future: _checkStartupSeen(),
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return const Scaffold(
                body: Center(child: CircularProgressIndicator()),
              );
            } else {
              bool seen = snapshot.data ?? false;
              if (!seen) {
                // First time launch → show startup page.
                return const StartupPage();
              } else {
                // Otherwise, use the auth wrapper below.
                return const AuthWrapper();
              }
            }
          },
        ),
        // Define routes.
        routes: {
          '/login': (context) => LoginScreen(),
          '/register': (context) => RegisterScreen(),
          '/navigationBar':
              (context) => NavigationBarScreen(
                onLocaleChange: (Locale newLocale) {
                  MyApp.setLocale(context, newLocale);
                },
              ),
          '/auth': (context) => const AuthWrapper(),
        },
      ),
    );
  }
}

/// Listens to Firebase authentication state changes.
/// If a user is logged in, shows the NavigationBarScreen; otherwise, shows the LoginScreen.
class AuthWrapper extends StatelessWidget {
  const AuthWrapper({super.key});
  @override
  Widget build(BuildContext context) {
    return StreamBuilder<User?>(
      stream: FirebaseAuth.instance.authStateChanges(),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          return const Scaffold(
            body: Center(child: CircularProgressIndicator()),
          );
        } else if (snapshot.hasData) {
          return NavigationBarScreen(
            onLocaleChange: (Locale newLocale) {
              MyApp.setLocale(context, newLocale);
            },
          );
        } else {
          return LoginScreen();
        }
      },
    );
  }
}
