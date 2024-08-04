# FamilyTreeProject 2.5 🌳

## Описание проекта

Этот проект представляет собой приложение для управления семейным деревом. Он позволяет добавлять членов семьи, просматривать дерево, а также сохранять и загружать данные в/из файлов.

## Структура проекта

Проект организован по следующей структуре:

```
src/
|-- app/
|   |-- model/
|   |   |-- FamilyMember.java
|   |   |-- FamilyTree.java
|   |   |-- Gender.java
|   |   |-- Human.java
|   |   |-- IModel.java
|   |   |-- Model.java
|   |-- presenter/
|   |   |-- IPresenter.java
|   |   |-- Presenter.java
|   |-- view/
|   |   |-- IView.java
|   |   |-- View.java
|   |-- Main.java
|   |-- UserInterface.java
|-- util/
|   |-- DateOfBirthComparator.java
|   |-- FamilyTreeFileHandler.java
|   |-- NameComparator.java
```

## Классы и интерфейсы

### `app.model`

- **FamilyMember**

  - Расширяет класс `Human` и добавляет поле `id`, представляющее уникальный идентификатор члена семьи.
  - **Методы:**
    - Конструктор `FamilyMember(String name, Gender gender, String dateOfBirth, int id)`
    - `getId()`
    - Переопределенный метод `toString()`

- **FamilyTree**

  - Хранит список членов семьи и предоставляет методы для управления этим списком.
  - **Методы:**
    - Конструктор `FamilyTree()`
    - `addMember(FamilyMember member)`
    - `getMembers()`
    - Переопределенный метод `toString()`

- **Gender**

  - Перечисление для представления пола: `MALE` и `FEMALE`.

- **Human**

  - Представляет человека с полями `name`, `gender`, и `dateOfBirth`.
  - **Методы:**
    - Конструктор `Human(String name, Gender gender, String dateOfBirth)`
    - `getName()`
    - `getGender()`
    - `getDateOfBirth()`
    - Переопределенный метод `toString()`

- **IModel**

  - Интерфейс для модели, определяет методы для управления данными семейного дерева.
  - **Методы:**
    - `addMember(FamilyMember member)`
    - `getFamilyTree()`
    - `saveFamilyTree(String fileName)`
    - `loadFamilyTree(String fileName)`

- **Model**
  - Реализация интерфейса `IModel`, управляет данными семейного дерева, включая сохранение и загрузку из файлов.
  - **Методы:**
    - Конструктор `Model()`
    - `addMember(FamilyMember member)`
    - `getFamilyTree()`
    - `saveFamilyTree(String fileName)`
    - `loadFamilyTree(String fileName)`

### `app.presenter`

- **IPresenter**

  - Интерфейс для презентера, определяет методы для управления взаимодействием с пользователем.
  - **Методы:**
    - `start()`
    - `addFamilyMember()`
    - `viewFamilyTree()`
    - `saveFamilyTree()`
    - `loadFamilyTree()`

- **Presenter**
  - Реализация интерфейса `IPresenter`, управляет логикой приложения и взаимодействием с моделью и видом.
  - **Методы:**
    - Конструктор `Presenter(IModel model, IView view)`
    - `start()`
    - `addFamilyMember()`
    - `viewFamilyTree()`
    - `saveFamilyTree()`
    - `loadFamilyTree()`

### `app.view`

- **IView**

  - Интерфейс для вида, определяет методы для отображения данных и получения ввода от пользователя.
  - **Методы:**
    - `displayMenu()`
    - `getInput()`
    - `showMessage(String message)`
    - `displayFamilyTree(String familyTree)`

- **View**
  - Реализация интерфейса `IView`, предоставляет текстовый интерфейс для взаимодействия с пользователем.
  - **Методы:**
    - Конструктор `View()`
    - `displayMenu()`
    - `getInput()`
    - `showMessage(String message)`
    - `displayFamilyTree(String familyTree)`

### `util`

- **DateOfBirthComparator**

  - Компаратор для сортировки членов семьи по дате рождения.
  - **Метод:**
    - `compare(FamilyMember o1, FamilyMember o2)`

- **FamilyTreeFileHandler**

  - Обрабатывает сохранение и загрузку семейного дерева в/из файла.
  - **Методы:**
    - `saveToFile(FamilyTree familyTree, String fileName)`
    - `load(String fileName)`

- **NameComparator**
  - Компаратор для сортировки членов семьи по имени.
  - **Метод:**
    - `compare(FamilyMember o1, FamilyMember o2)`

## Информация о разработчике 👤

- **Группа:** 6381
- **Фамилия и Имя:** Bakun Denis
