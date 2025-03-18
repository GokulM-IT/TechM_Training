import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'dart:async';

class AppLocalizations {
  final Locale locale;

  AppLocalizations(this.locale);

  static AppLocalizations? of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations);
  }

  static const LocalizationsDelegate<AppLocalizations> delegate =
      _AppLocalizationsDelegate();

  static final Map<String, Map<String, String>> _localizedValues = {
    'en': {
      'home': 'Home',
      'favorites': 'Favorites',
      'add_course': 'Add Course',
      'course_details': 'Course Details',
      'course_title': 'Course Title',
      'price': 'Price',
      'instructor': 'Instructor',
      'description': 'Description',
      'duration': 'Duration',
      'image_url': 'Image URL',
      'change_language': 'Change Language',
      'category': 'Category',
      'save': 'Save',
      'remove': 'Remove',
      'enroll_now': 'Enroll Now',
      'course_added': 'Course successfully added!',
      'please_enter': 'Please enter',
      'enter_valid_number': 'Please enter a valid number',
      'firebase_error': 'Firebase error',
      'unexpected_error': 'An unexpected error occurred',
      // New keys for the logout page
      'user_settings': 'User',
      'logout': 'Logout',
      'are_you_sure_logout': 'Are you sure you want to logout?',
      'confirm': 'Confirm',
      'cancel': 'Cancel',
      'delete': 'Delete',
      // New keys for the login & register forms
      'login': 'Login',
      'register': 'Register',
      'email': 'Email',
      'password': 'Password',
      'dont_have_account': "Don't have an account? Register here",
      'already_have_account': "Already have an account? Login here",
      'get_started': 'Get Started',
    },
    'ta': {
      'home': 'முகப்பு',
      'favorites': 'பிடித்தவை',
      'add_course': 'பாடம் சேர்க்கவும்',
      'course_details': 'பயிற்சி விவரம்',
      'course_title': 'பாட தலைப்பு',
      'price': 'விலை',
      'instructor': 'பயிற்றுநர்',
      'description': 'விளக்கம்',
      'duration': 'காலம்',
      'image_url': 'பட URL',
      'change_language': 'மொழியை மாற்று',
      'category': 'வகை',
      'save': 'சேமிக்கவும்',
      'remove': 'அகற்று',
      'enroll_now': 'சேரவும்',
      'course_added': 'பாடம் வெற்றிகரமாக சேர்க்கப்பட்டது!',
      'please_enter': 'தயவுசெய்து உள்ளிடவும்',
      'enter_valid_number': 'சரியான எண்ணை உள்ளிடவும்',
      'firebase_error': 'பிழை: Firebase',
      'unexpected_error': 'எதிர்பாராத பிழை ஏற்பட்டது',
      // New keys for the logout page
      'user_settings': 'பயனர்',
      'logout': 'வெளியேறு',
      'are_you_sure_logout': 'நீங்கள் வெளியேற விரும்புகிறீர்களா?',
      'confirm': 'உறுதி செய்யவும்',
      'cancel': 'ரத்து செய்யவும்',
      'delete': 'நீக்கவும்',
      // New keys for the login & register forms
      'login': 'உள்நுழை',
      'register': 'பதிவு',
      'email': 'மின்னஞ்சல்',
      'password': 'கடவுச்சொல்',
      'dont_have_account': "கணக்கு இல்லை? இங்கே பதிவு செய்யவும்",
      'already_have_account': "ஏற்கனவே கணக்கு உள்ளது? இங்கே உள்நுழையவும்",
      'get_started': 'தொடங்குங்கள்',
    },
  };

  String translate(String key) {
    return AppLocalizations._localizedValues[locale.languageCode]?[key] ?? key;
  }
}

class _AppLocalizationsDelegate
    extends LocalizationsDelegate<AppLocalizations> {
  const _AppLocalizationsDelegate();

  @override
  bool isSupported(Locale locale) {
    return AppLocalizations._localizedValues.containsKey(locale.languageCode);
  }

  @override
  Future<AppLocalizations> load(Locale locale) async {
    return SynchronousFuture<AppLocalizations>(AppLocalizations(locale));
  }

  @override
  bool shouldReload(LocalizationsDelegate<AppLocalizations> old) => false;
}
