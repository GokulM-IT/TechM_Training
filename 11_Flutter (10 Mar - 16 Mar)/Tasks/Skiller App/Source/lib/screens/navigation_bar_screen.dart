import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/course_provider.dart';
import '../providers/favorite_provider.dart';
import '../screens/home_screen.dart';
import '../screens/favorite_screen.dart';
import '../screens/add_course_screen.dart';
import '../screens/user_settings_page.dart';
import '../localization/app_localizations.dart';

class NavigationBarScreen extends StatefulWidget {
  final Function(Locale) onLocaleChange;

  const NavigationBarScreen({super.key, required this.onLocaleChange});

  @override
  State<NavigationBarScreen> createState() => _NavigationBarScreenState();
}

class _NavigationBarScreenState extends State<NavigationBarScreen> {
  int _selectedIndex = 0;
  late List<Widget> _pages;

  @override
  void initState() {
    super.initState();
    // Initialize the pages for the navigation bar.
    _pages = [
      const HomeScreen(), // Home Tab
      const FavoriteScreen(), // Favorites Tab
      const AddCourseScreen(), // Add Course Tab
      const UserSettingsPage(), // User Tab
    ];
    _loadInitialData();
  }

  void _loadInitialData() {
    Provider.of<CourseProvider>(context, listen: false).fetchCourses();
    Provider.of<FavoriteProvider>(context, listen: false).loadFavorites();
  }

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  void _changeLanguage() {
    Locale currentLocale = Localizations.localeOf(context);
    Locale newLocale =
        currentLocale.languageCode == 'en'
            ? const Locale('ta')
            : const Locale('en');
    widget.onLocaleChange(newLocale);
  }

  @override
  Widget build(BuildContext context) {
    final localizations = AppLocalizations.of(context);
    return Scaffold(
      appBar: AppBar(
        title: Text(
          localizations != null
              ? (_selectedIndex == 0
                  ? localizations.translate('home')
                  : _selectedIndex == 1
                  ? localizations.translate('favorites')
                  : _selectedIndex == 2
                  ? localizations.translate('add_course')
                  : localizations.translate('user_settings'))
              : 'App',
        ),
        backgroundColor: Colors.pink.shade50,
        actions: [
          IconButton(
            icon: const Icon(Icons.language),
            onPressed: _changeLanguage,
          ),
        ],
      ),
      body: Container(
        decoration: BoxDecoration(
          // Use the same gradient background as other pages.
          gradient: LinearGradient(
            colors: [Colors.pink.shade50, Colors.white],
            begin: Alignment.topCenter,
            end: Alignment.bottomCenter,
          ),
        ),
        child: _pages[_selectedIndex],
      ),
      bottomNavigationBar: Container(
        color: const Color.fromARGB(255, 235, 235, 235),
        child: ExtraProfessionalBottomNavigationBar(
          currentIndex: _selectedIndex,
          onTap: _onItemTapped,
          items: [
            CustomBottomNavItem(
              icon: Icons.home,
              label: localizations?.translate('home') ?? 'Home',
            ),
            CustomBottomNavItem(
              icon: Icons.favorite,
              label: localizations?.translate('favorites') ?? 'Favorites',
            ),
            CustomBottomNavItem(
              icon: Icons.add,
              label: localizations?.translate('add_course') ?? 'Add Course',
            ),
            CustomBottomNavItem(
              icon: Icons.person,
              label: localizations?.translate('user_settings') ?? 'User',
            ),
          ],
        ),
      ),
    );
  }
}

/// ExtraProfessionalBottomNavigationBar provides a custom animated bottom navigation bar.
class ExtraProfessionalBottomNavigationBar extends StatefulWidget {
  final int currentIndex;
  final ValueChanged<int> onTap;
  final List<CustomBottomNavItem> items;

  const ExtraProfessionalBottomNavigationBar({
    super.key,
    required this.currentIndex,
    required this.onTap,
    required this.items,
  });

  @override
  State<ExtraProfessionalBottomNavigationBar> createState() =>
      _ExtraProfessionalBottomNavigationBarState();
}

class _ExtraProfessionalBottomNavigationBarState
    extends State<ExtraProfessionalBottomNavigationBar>
    with SingleTickerProviderStateMixin {
  late AnimationController _controller;
  late Animation<double> _animation;

  @override
  void initState() {
    super.initState();
    _controller = AnimationController(
      vsync: this,
      duration: const Duration(milliseconds: 300),
    );
    _animation = Tween<double>(
      begin: widget.currentIndex.toDouble(),
      end: widget.currentIndex.toDouble(),
    ).animate(CurvedAnimation(parent: _controller, curve: Curves.easeOut));
  }

  @override
  void didUpdateWidget(
    covariant ExtraProfessionalBottomNavigationBar oldWidget,
  ) {
    super.didUpdateWidget(oldWidget);
    if (widget.currentIndex != oldWidget.currentIndex) {
      _animation = Tween<double>(
        begin: oldWidget.currentIndex.toDouble(),
        end: widget.currentIndex.toDouble(),
      ).animate(CurvedAnimation(parent: _controller, curve: Curves.easeOut));
      _controller
        ..reset()
        ..forward();
    }
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    int itemCount = widget.items.length;
    double width = MediaQuery.of(context).size.width;
    double itemWidth = width / itemCount;

    return SizedBox(
      height: 80,
      child: Stack(
        children: [
          // Custom curved bump indicator.
          AnimatedBuilder(
            animation: _animation,
            builder: (context, child) {
              double pos = (_animation.value + 0.5) * itemWidth;
              return CustomPaint(
                size: Size(width, 80),
                painter: _NavBarCustomPainter(selectedPos: pos),
              );
            },
          ),
          // Navigation items row.
          Row(
            children:
                widget.items.asMap().entries.map((entry) {
                  int index = entry.key;
                  final item = entry.value;
                  bool isSelected = index == widget.currentIndex;
                  return Expanded(
                    child: InkWell(
                      borderRadius: BorderRadius.circular(30),
                      onTap: () => widget.onTap(index),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: [
                          AnimatedScale(
                            scale: isSelected ? 1.3 : 1.0,
                            duration: const Duration(milliseconds: 300),
                            curve: Curves.easeOut,
                            child: Icon(
                              item.icon,
                              color:
                                  isSelected
                                      ? const Color.fromARGB(255, 88, 63, 247)
                                      : const Color.fromARGB(179, 0, 0, 0),
                              size: isSelected ? 30 : 24,
                            ),
                          ),
                          const SizedBox(height: 4),
                          AnimatedDefaultTextStyle(
                            duration: const Duration(milliseconds: 300),
                            style: TextStyle(
                              color:
                                  isSelected
                                      ? const Color.fromARGB(255, 88, 63, 247)
                                      : const Color.fromARGB(179, 0, 0, 0),
                              fontSize: isSelected ? 14 : 12,
                              fontWeight:
                                  isSelected
                                      ? FontWeight.bold
                                      : FontWeight.normal,
                            ),
                            child: Text(
                              item.label,
                              overflow: TextOverflow.ellipsis,
                              maxLines: 1,
                            ),
                          ),
                        ],
                      ),
                    ),
                  );
                }).toList(),
          ),
        ],
      ),
    );
  }
}

/// Custom painter to draw a curved bump indicator for the selected tab.
class _NavBarCustomPainter extends CustomPainter {
  final double selectedPos;

  _NavBarCustomPainter({required this.selectedPos});

  @override
  void paint(Canvas canvas, Size size) {
    // Use white for the indicator against the app color background.
    final Paint paint = Paint()..color = Colors.white;
    final Path path = Path();

    // Increase the curve width and height.
    path.moveTo(0, 0);
    // Start bump from a wider offset.
    path.lineTo(selectedPos - 40, 0);
    // Curve upward (higher bump).
    path.quadraticBezierTo(selectedPos - 20, 0, selectedPos - 20, 30);
    // Arc from left to right part of bump.
    path.arcToPoint(
      Offset(selectedPos + 20, 30),
      radius: const Radius.circular(20),
      clockwise: false,
    );
    // Curve downward smoothly.
    path.quadraticBezierTo(selectedPos + 20, 0, selectedPos + 40, 0);
    // Continue to the right edge.
    path.lineTo(size.width, 0);
    path.lineTo(size.width, size.height);
    path.lineTo(0, size.height);
    path.close();

    canvas.drawShadow(path, Colors.black26, 4.0, true);
    canvas.drawPath(path, paint);
  }

  @override
  bool shouldRepaint(covariant _NavBarCustomPainter oldDelegate) {
    return oldDelegate.selectedPos != selectedPos;
  }
}

/// Model for each custom bottom navigation item.
class CustomBottomNavItem {
  final IconData icon;
  final String label;

  const CustomBottomNavItem({required this.icon, required this.label});
}
