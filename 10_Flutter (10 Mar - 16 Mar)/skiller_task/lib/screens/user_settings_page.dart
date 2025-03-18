import 'package:flutter/material.dart';
import 'package:firebase_auth/firebase_auth.dart';
import '../localization/app_localizations.dart';

class UserSettingsPage extends StatelessWidget {
  const UserSettingsPage({super.key});

  // Actual logout method.
  void _logout(BuildContext context) {
    FirebaseAuth.instance.signOut();
    Navigator.pushReplacementNamed(context, '/login');
  }

  // Show a logout confirmation dialog with custom styling.
  void _confirmLogout(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    showDialog(
      context: context,
      builder: (BuildContext dialogContext) {
        return AlertDialog(
          // Give the dialog rounded corners.
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(20.0),
          ),
          title: Text(
            localizations?.translate('logout') ?? 'Logout',
            style: const TextStyle(fontWeight: FontWeight.bold),
          ),
          content: Text(
            localizations?.translate('are_you_sure_logout') ??
                'Are you sure you want to logout?',
            style: const TextStyle(fontSize: 16),
          ),
          actions: [
            // Cancel button styled in grey.
            TextButton(
              onPressed: () => Navigator.of(dialogContext).pop(),
              style: TextButton.styleFrom(foregroundColor: Colors.grey),
              child: Text(
                localizations?.translate('cancel') ?? 'Cancel',
                style: const TextStyle(fontSize: 16),
              ),
            ),
            // Confirm button styled in red.
            TextButton(
              onPressed: () {
                Navigator.of(dialogContext).pop();
                _logout(context);
              },
              style: TextButton.styleFrom(foregroundColor: Colors.red),
              child: Text(
                localizations?.translate('confirm') ?? 'Confirm',
                style: const TextStyle(
                  fontSize: 16,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);

    return ListView(
      children: [
        ListTile(
          leading: const Icon(Icons.logout),
          title: Text(localizations?.translate('logout') ?? 'Logout'),
          onTap: () => _confirmLogout(context), // Show confirmation dialog.
        ),
        // You can add more settings options here.
      ],
    );
  }
}
