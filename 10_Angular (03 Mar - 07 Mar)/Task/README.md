# Campspot - Angular SPA

## About the Website

**Campspot** is a web application built using Angular that allows users to view available campsites, log in, and add new camps to the list. The app provides a user-friendly interface to browse through camp locations, prices, stay duration, and ratings. Users can also submit new camps with details like images, descriptions, and prices.

The application features forms for user authentication and camp submission, and utilizes Angular’s powerful features like routing, observables, pipes, directives, and services to create a dynamic and interactive experience.

## Website Preview

### Home Page

![Home Page](https://res.cloudinary.com/dhgeqswqq/image/upload/v1741623849/Screenshot_2025-03-10_012807_q2jtbw.png)

### New Camp Adding Page

![New Camp Adding Page](https://res.cloudinary.com/dhgeqswqq/image/upload/v1741623848/Screenshot_2025-03-10_012851_qbi1hy.png)

### Login Page

![Login Page](https://res.cloudinary.com/dhgeqswqq/image/upload/v1741623848/Screenshot_2025-03-10_012908_tzprl9.png)

---

## Tasks Implemented

### 1. **Components**

- The project contains the following components:
  - `AppComponent`
  - `HomeComponent`
  - `CampsComponent`
  - `NewCampComponent`
  - `NavBarComponent`
  - `LoginComponent`
  - `FooterComponent`

### 2. **Parent to Child Components**

- Implemented parent-child relationship between components:
  - The `HomeComponent` acts as a parent and contains a list of camps. It passes the data to the `CampsComponent`, which renders individual camp details.

### 3. **Structural and Attribute Directives**

- **Structural Directives**:

  - Used in the `NewCampComponent` to conditionally display the success message when a new camp is successfully submitted. The directive dynamically adds or removes the success message from the DOM based on the form submission status.
  - **`*ngFor`**: Used in the `HomeComponent` to iterate over the list of camps and display individual camp cards dynamically.

- **Attribute Directives**:
  - Implemented in the `NavBarComponent` for dynamic routing, user interaction, and styling adjustments.
  - **`[routerLink]`**: Used to navigate between pages based on user clicks.
  - **`[class.img-container]`**: Dynamically applied to conditionally style the user icon container depending on the login state.
  - **`[ngClass]`**: Used to toggle CSS classes based on a condition to display or hide the popup menu.

### 4. **@Input**

- In the `HomeComponent`, data is passed to the `CampsComponent` using `@Input()`. The `HomeComponent` sends the list of camps, and `CampsComponent` receives and displays them.

### 5. **Basic Routing**

- The application includes basic routing to navigate between different views:
  - **`HomeComponent`**: Displays the homepage.
  - **`LoginComponent`**: Handles user login functionality.
  - **`NewCampComponent`**: Handles the form for adding a new campsite.

### 6. **Services**

- Implemented a service `CampsService` to interact with the backend API for fetching and adding camp details.

### 7. **Observables**

- Used **Observables** to handle asynchronous HTTP requests for fetching and submitting camp data through the `CampsService`.

### 8. **API Calls**

- The `CampsService` makes **GET** and **POST** requests to the backend API for retrieving and submitting camp data.

### 9. **Template and Reactive Forms**

- **Template-driven form** in the `NewCampComponent` is used for adding a new camp with validation.
- **Reactive form** in the `LoginComponent` is used for validating the login form, including username and password fields.

### 10. **Pipes**

- Custom pipes like `customCurrency` and `star` have been created and used in the `CampsComponent` for displaying prices in INR format and showing ratings with stars, respectively.

---

## How to Run the Application

Follow these steps to run the Angular SPA application locally:

### Prerequisites

- **Node.js**: Make sure you have Node.js installed on your machine. You can check if it's installed by running:

```bash
 node -v
```

If not installed, download and install Node.js from the [official website](https://nodejs.org/).

- **Angular CLI**: If you don't have Angular CLI installed, you can install it globally using:

```bash
npm install -g @angular/cli
```

### 1. Download the Project

Download the project as a ZIP file from the repository or clone it using your preferred method. After downloading, extract the project folder.

Once extracted, navigate to the project directory using your terminal:

```
cd Campspot_Task
```

### 2. Install Dependencies

Once you have the project on your machine, navigate to the project folder and install the dependencies by running:

```
npm install
```

### 3. Start the Application

To run the Angular application, use the Angular CLI’s ng serve command:

```
ng serve
```

This will compile the application and start a local development server. By default, the application will be accessible at http://localhost:4200/.

### 4. Open the Application in Your Browser

After the build completes successfully, open your browser and navigate to:

```
http://localhost:4200
```

The application should be up and running. You can start exploring the pages, log in, view campsites, and add new camps!

---

## API

The app interacts with a backend API to fetch and submit camp data. The backend is provided through a local camps.json file located within the project folder. Ensure you have a JSON server running to serve the camps.json file as a mock API.

### Starting JSON Server

To start the backend API locally, follow these steps:

1. Install the json-server package globally if you haven't already:

```
npm install -g json-server
```

2. Start the server to serve the camps.json file:

```
json-server --watch camps.json --port 4050
```

The backend API will now be available at http://localhost:4050.

## New Camp Submission

When adding a new camp, you can use the following image links to display images for the new camps:

- https://res.cloudinary.com/dhgeqswqq/image/upload/v1722163783/Image_11_drh2k8.jpg
- https://res.cloudinary.com/dhgeqswqq/image/upload/v1722163783/Image_9_enbjlh.jpg
- https://res.cloudinary.com/dhgeqswqq/image/upload/v1722163783/Image_1_fwwfdw.jpg
- https://res.cloudinary.com/dhgeqswqq/image/upload/v1722163783/Image_6_qwz8jj.jpg
- https://res.cloudinary.com/dhgeqswqq/image/upload/v1722163782/Image_7_sjqes2.jpg
- https://res.cloudinary.com/dhgeqswqq/image/upload/v1722163782/Image_10_cguqlo.jpg

These image links can be used when adding a new camp via the NewCampComponent form.

## Login Details

To log in to the application, use the following credentials:

- Username: john
- Password: password

Once logged in, you can navigate through the application and add camps to your list.
