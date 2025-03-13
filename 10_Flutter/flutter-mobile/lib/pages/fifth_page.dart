import 'package:flutter/material.dart';

class FifthPage extends StatelessWidget {
  const FifthPage({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Fifth Page - Layouts'),
        backgroundColor: Colors.black,
        foregroundColor: Colors.white,
      ),
      body: SingleChildScrollView(
        padding: EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Text(
              'Row Layout:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                Container(color: Colors.blue, height: 50, width: 50),
                Container(color: Colors.red, height: 50, width: 50),
                Container(color: Colors.green, height: 50, width: 50),
              ],
            ),
            SizedBox(height: 20),
            Text(
              'Column Layout:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: <Widget>[
                Container(color: Colors.blue, height: 50),
                SizedBox(height: 10),
                Container(color: Colors.red, height: 50),
                SizedBox(height: 10),
                Container(color: Colors.green, height: 50),
              ],
            ),
            SizedBox(height: 20),
            Text(
              'Stack Layout:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            Container(
              height: 150,
              child: Stack(
                children: <Widget>[
                  Container(color: Colors.blue, height: 150, width: 150),
                  Positioned(
                    top: 50,
                    left: 50,
                    child: Container(
                      color: Colors.red,
                      height: 100,
                      width: 100,
                    ),
                  ),
                  Positioned(
                    top: 100,
                    left: 100,
                    child: Container(
                      color: Colors.green,
                      height: 50,
                      width: 50,
                    ),
                  ),
                ],
              ),
            ),
            SizedBox(height: 20),
            Text(
              'Grid Layout:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            GridView.count(
              crossAxisCount: 3,
              crossAxisSpacing: 10,
              mainAxisSpacing: 10,
              shrinkWrap: true,
              physics:
                  NeverScrollableScrollPhysics(), // Prevents nested scrolling
              children: <Widget>[
                Container(color: Colors.blue),
                Container(color: Colors.red),
                Container(color: Colors.green),
                Container(color: Colors.orange),
                Container(color: Colors.purple),
                Container(color: Colors.yellow),
              ],
            ),
            SizedBox(height: 20),
            Text(
              'More Content to Test Scrolling:',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            Container(
              color: Colors.blue[100],
              height: 100,
              width: double.infinity,
              margin: EdgeInsets.symmetric(vertical: 10),
              child: Center(child: Text('Extra Content 1')),
            ),
            Container(
              color: Colors.red[100],
              height: 100,
              width: double.infinity,
              margin: EdgeInsets.symmetric(vertical: 10),
              child: Center(child: Text('Extra Content 2')),
            ),
            Container(
              color: Colors.green[100],
              height: 100,
              width: double.infinity,
              margin: EdgeInsets.symmetric(vertical: 10),
              child: Center(child: Text('Extra Content 3')),
            ),
          ],
        ),
      ),
    );
  }
}
