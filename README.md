# Veryable

# Android Coding Challenge
As a Mobile Developer at Veryable, most of the times we implement UI prototypes by following the design guidelines. 
For this exercise, we have provided you a scenario which you will need to develop. We have also included the required assets (images, colors etc.) and a base project for this exercise.

# Instructions:
Please read the following instructions along with the Wireframe.pdf file to understand the requirement of the application correctly. Wireframe.pdf is the document that details the interaction flow of the application. Please follow the fonts and color guideline included in wireframe.pdf.
1. The purpose of this exercise is to build an app where you can see the list of your banking and card accounts (Accounts View). Please use the attached base project to add your code.
2. The list on Accounts View is vertically scrollable. When user touch one of the items, the app should take them to next page (Detail View) where users can see the details.
3. The user can touch either the physical Done button or the back arrow at the top left corner on Detail View to go back to the Accounts View.
4. For each screen, display the Name on Toolbar.
5. On the Accounts View, you should make a network call to fetch the data from the [JSON file](https://veryable-public-assets.s3.us-east-2.amazonaws.com/veryable.json) hosted on AWS. The application should read the Json data and display in order.
6. For each item in the data, display the following items:
   * Display the Bank or Card image (included in Assets Zip) depending on the account type.
   * Display Account name.
   * Display Account Description.
   * Display transfer type which is ACH-Same Day for Bank Account and Instant for a Card.
   * Display an arrow on the right side.

# Dependencies:
   * implementation 'org.jetbrains.anko:anko:0.10.8'
   * implementation 'com.google.code.gson:gson:2.9.0'
   
# Notes:
All requiremnts have been met.

The project was sent as a Kotlin based app, built using XML layouts, I kept the original structure and didnt migrate it to jetpack compose as per the documentations specifications "Please use the attached base project to add your code".

The app contains two activites, one for the Account View, another for the Detail View. No fragments were used because an app this size doesnt require lots of lifecycle managment, plus it was mentioned that the lead dev was trying to move away from fragments and views.

Some colors and fonts were not provided, so I tried to match them as close as possible.

# Conclusion:

Making this app was fun and interesting, provided me more insight over how kotlin has eveolved over the years. Some libraries were deprciated and other syntax were changed (outdated).

Listing the Bank Accounts and Cards seperatly was an intersting process. So many possible ways to implement it, I chose to parse the JSON file and seperate the data into two lists, one for each account type, then pass it throught the recycler view to display accordingly. 
