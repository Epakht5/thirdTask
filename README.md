В этом проекте я пишу небольшой фреймворк, где тестирую сайт "Tools QA Demo" на браузерах Chrome и FireFox, следуя тестовым сценариям, описанным ниже:

Test case 1.
Шаги
Ожидаемые результаты
1. Перейти на главную страницу
Главная страница открыта
2. Кликнуть на кнопку Alerts, Frame & Windows.
На открывшейся странице в левом меню кликнуть пункт Alerts
На странице появилась форма Alerts
3. Нажать на кнопку Click Button to see alert
Открыт алерт с текстом "You clicked a button"
4. Нажать на кнопку OK
Алерт закрылся
5. Нажать на кнопку On button click, confirm box will appear
Открыт алерт с текстом "Do you confirm action?"
6. Нажать на кнопку OK
Алерт закрылся
Рядом с кнопкой появилась надпись "You selected Ok"
7. Нажать на кнопку On button click, prompt box will appear
Открыт алерт с текстом "Please enter your name"
8. Ввести случайно сгенерированный текст, нажать на кнопку OK
Алерт закрылся
Появившийся текст соответствует введенному в алерт

Test case 2.
Шаги
Ожидаемые результаты
1. Перейти на главную страницу
Главная страница открыта
2. Кликнуть на кнопку Alerts, Frame & Windows.
На открывшейся странице в левом меню кликнуть пункт Nested Frames
Открыта страница с формой Nested Frames. В центре страницы присутствуют надписи "Parent frame" и "Child Iframe"
3. В левом меню выбрать пункт Frames.
Открыта страница с формой Frames. Надпись из верхнего фрейма соответствует надписи из нижнего

Test case 3.
Шаги
Ожидаемые результаты
1. Перейти на главную страницу
Главная страница открыта
2. Кликнуть на кнопку Elements.
На открывшейся странице в левом меню кликнуть пункт Web Tables
Открыта страница с формой Web Tables
3. Кликнуть на кнопку Add
На странице появилась форма Registrarion Form
4. Ввести данные пользователя User № из таблицы и затем нажать на кнопку Submit
Форма регистрации закрыта.
В таблице появились данные пользователя User №
5. Нажать на кнопку Delete в строке пользователя User №
Количество записей в таблице изменилось.
Пользователь User № удалился из таблицы

Test case 4.
Шаги
Ожидаемые результаты
1. Перейти на главную страницу
Главная страница открыта
2. Кликнeть на кнопку Alerts, Frame & Windows.
На открывшейся странице в левом меню кликнуть пункт Browser Windows
Открыта страница с формой Browser Windows
3. Кликнуть на кнопку New Tab
Открыта новая вкладка /sample со страницей sample page
4.Закрыть текущую вкладку
Открыта страница с формой Browser Windows
5. В левом меню выбрать Elements → Links
Открыта страница с формой Links
6. Перейти по ссылке Home
Открыта новая вкладка с главной страницей
7. Переключиться на прошлую вкладку
Открыта страница с формой Links


ВПАЖНОЕ ПРИМЕЧАНИЕ: В этом проекте есть возможность выполнения тест-кейсов на разных браузерах "Chrome" и "FireFox". Но для того, чтобы воспользоваться этой особенностью, небходимо в файле config.json 
в параметре "BrowserType" написать "chrome", если хотите увидеть реализацию тестовых сценариев на Chrome, или "firefox", если на FireFox.
