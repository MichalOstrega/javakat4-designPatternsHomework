# javakat4-designPatternsHomework

Ponieważ nie ma klasy main oraz zestawu danych, do zadań postaraj się pisać testy jednostkowe!

1. Zaimplementuj wzorzec Interpreter, aby zwalidować dane w PersonalInformationData. Każda klasa powinna sprawdzać jedno z pól:
  * Personal Indentification Number - nie może być null i musi mieć 11 znaków
  * City - nie może być puste i musi mieć conajmniej 1 znak
  * Street - nie może być puste i musi mieć conajmniej 1 znak
  * HouseNumber - nie może być puste i musi mieć numer większy od 1
  * Zaimplementuj jedną, nadrzędną regułę grupującą powyższe.
  * Połącz wzorzec interpreter z wzorcem Composite, aby uzyskać jednolitą strukturę
2. Zaimplementuj wzorzec Interpreter, aby zwalidować dane w ContactInformation. Każda klasa powinna sprawdzać jedno z pól:
  * Personal Indentification Number - nie może być null i musi mieć 11 znaków
  * Name - nie może być puste i musi mieć conajmniej 1 znak
  * Surname - nie może być puste i musi mieć conajmniej 1 znak
  * Użyj reguły grupującej z poprzedniego zadania, aby uzyskać jednolitą strukturę
3. Zaimplementuj wzorzec Decorator, aby "opakować" obiekt PersonalInformationData, tak, aby posiadał metodę getValidData, która będzie używała interpretera do weryfikowania danych.
4. Zaimplementuj wzorzec Decorator, aby "opakować" obiekt ContactInformation, tak, aby posiadał metodę getValidData, która będzie używała interpretera do weryfikowania danych.
5. Zaimplementuj wzorzec Builder dla klasy Person. Użyj go w klasie PersonDataCollector.
6. Zaimplementuj wzorzec Singleton, aby przechowywać dane konfiguracyjne (nazwy userów i hasła)
7. Zoptymalizuj łączenie danych PersonalInformation z ContactInformation. Postaraj się wymyślić, jak zmniejszyć złożoność obliczeniową. Postaraj się użyć stream api.
8. Rozszerz walidację ContactInformation o proste sprawdzenie poprawności numeru telefonu:
  * numer telefonu musi się zaczyna od 0048 albo +48
  * następnie powinno znajdować się 9 cyfr albo trzy 3-cyfrowe człony rozdzelone myślnikami.  
  Przykłady: +48112233445, 0048123456789 0048123-456-789
