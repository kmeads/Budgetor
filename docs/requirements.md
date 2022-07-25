# Requirements - Budgetor
### Introduction
Budgetor will be a web application designed to deliver budgeting and financial tracking needs to end-users.  The web application will eventually be converted over to an application run by iOS, Android, & Desktop Application.

### 1. Roles & Goals
- **1.1** User
    - **1.1.1:** Easily be able to add, remove, and modify budget categories.
    - **1.1.2:** Easily be able to view relavent information regarding the end-users finances in a convenient and understandable manner such as graphs or numbers.
    - **1.1.3:** Be alerted when an untracked transaction is found and prompted to categorize it.
    - **1.1.4:** Be able to add other users to their budget.
        - **1.1.4.1:** Be able to modify other users permissions to their budget.
            - **1.1.4.1.1:** View Only
            - **1.1.4.1.2:** Edit
        - **1.1.4.2:** Be able to remove other users from their budget.
### 2. Functional Requirements
- A **User** will have a *first name*, *last name*, *phone number*, *email address*, and *password* for personal information.    
- **User** will have a list of *User Roles*.
    - **User Role** will inherit from a *Role* type.
        - **Role** will consist of three types.  *Owner*, *Editor*, and *Viewer*.
    - **User Role** will have a *planning sheet*.
        - **Planning Sheet** will have a list of *goals*.
            - **Goal (Abstract)** will have a *name/title*, *start DateTime*, *end DateTime*, *current amount*, *total amount*, and a *description*.
            - **Goal (Abstract)** can be either a *long-term goal*, or a *short-term* goal.
            - **Goal (Abstract)** can be a *savings goal (concrete)*.
            - **Goal (Abstract)** can be a *debt payment goal*.
                - **Debt Payment Goal (Concrete)** will have a *due date DateTime*, *monthly due date DateTime*, and *debt type*.
            - **Goal (Abstract)** can be a *retirement goal*.
            - **Goal (Abstract)** can be a *custom goal*.
        - **Planning Sheet** will have a list of *deductions*.
            - **deduction** will have a *name/title*, *amount*, and *type* (type can be a percentage or flat amount).
        - *2.2.2.3* **Planning Sheet** will have a list of *years*.
            - *2.2.2.3.1* **Year** will have a *gross income*, *deduction amount*, and *net income*.
            - *2.2.2.3.2* **Year** will have an *allotted amount*, *spent*, *remaining*, *reserved amount*, and *percentage of income*.
            - *2.2.2.3.3* **Year** will have HashMap of *categories* with the name of the category as the key, and the amount spent as the value.
            - *2.2.2.3.4* **Year** will have a list of *Months*.
                - *2.2.2.3.4.1* **Month** contains a *Budget*.
                    - *2.2.2.3.4.1.1* **Budget** can contain *Category Groups*. (visitor pattern?)
                        - *2.2.2.3.4.1.1.1* A **Category Group** can contain **sub-Category Groups**.
                        - *2.2.2.3.4.1.1.2* A **Category Group** must have a *name/title*.
                        - *2.2.2.3.4.1.1.3* A **Category Group** must have at least one *Category* either as its child or further nested within its subcategory groups.
                        - *2.2.2.3.4.1.1.4* A **Cateogory Group** will have an *Alloted Amount*, *Spent*, *Remaining*, *reserved amount*, and *Percentage of Income* variables.
                    - *2.2.2.3.4.1.2* **Budget** can contain one or more *categories*.
                        - *2.2.2.3.4.1.2.1* A **Category** must have a *name/title*.
                        - *2.2.2.3.4.1.2.2* A **Category** will have an *Alloted Amount*, *Spent*, *Remaining*, *reserved amount*, and *Percentage of Income* variables.
                    - *2.2.2.3.4.1.3* **Budget** will have an *Alloted Amount*, *Spent*, *Remaining*, *reserved amount*, and *Percentage of Income* variables.
                - *2.2.2.3.4.2* **Month** contains a HashMap of *transactions* where the name of the budget is the key, and a corresponding array list is the value.
                    - *2.2.2.3.4.2.1* **Transaction** will have a *DateTime*, *To/From Whom*, *Amount Transacted*, and *Memo* variables.
                - *2.2.2.3.4.3* **Month** contains an *Income*.
                    - *2.2.2.3.4.3.1* **Income** will have a *gross amount*, a *total deduction amount*, a *deduction* list, and a *net amount*.
                    - *2.2.2.3.4.3.2* **Income** will have a HashMap of *Income Sources* with the name of the income source as the key, and an *Income Source* as the value.
                        - *2.2.2.3.4.3.2.1* **Income Source** will have a *gross amount*, a *total deduction amount*, a *deduction* list, and a *net amount*.
                        - *2.2.2.3.4.3.2.2* **Income Source** will have a *name/title*.
                        - *2.2.2.3.4.3.2.3* **Income Source** will have an ArrayList of *income transactions*.
                            - *2.2.2.3.4.3.2.3.1* **Income Transaction** will have a *DateTime*, *amount*, *deduction amount*, *deduction* list, *net amount*, and a *comment*.
    
### 3. Non-Functional Requirements
- **3.1** Technologies:
    - **3.1.1** Languages & Libraries:
        - **3.1.1.1** Front End:
            - **3.1.1.1.1** HTML
            - **3.1.1.1.2** TailWind CSS
            - **3.1.1.1.3** ReactJS
        - **3.1.1.2** Back End:
            - **3.1.1.2.1** Kotlin
            - **3.1.1.2.2** Ktor
        - **3.1.1.3** DataBase:
            - **3.1.1.3.1** My SQL
    - **3.1.2** Version Control
        - **3.1.2.1** GitHub
        - **3.1.2.1** Git
    - **3.1.3** UML
        - **3.1.3.1** [Lucid Chart](www.lucid.app)
- **3.2** Dependencies
    - **3.2.1** Banking API: [yodlee](https://www.yodlee.com/)
    - **3.2.2** Payment API: [stripe](https://stripe.com/)
### 4. Future Features:
- **4.1** Create an application where the budget can be viewed & modified on an iOS or Android device.
- **4.2** Implement additional features such as credit score calculator, etc.