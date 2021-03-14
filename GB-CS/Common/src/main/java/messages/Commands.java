package messages;

public enum Commands {

    //REQUESTS

    REQUEST_SERVER_UPLOAD_FILE, //запрос на сервер загрузки файла от клиента
    REQUEST_SERVER_REFRESH_FILES_LIST, //запрос на сервер обновления списка файлов
    REQUEST_SERVER_DELETE_FILE, //запрос на сервер удаление файла
    REQUEST_SERVER_DOWNLOAD_FILE, //запрос на сервер скачивания файла с сервера
    REQUEST_SERVER_CONNECTION, //запрос на сервер подключения и авторизации пользователя


    //RESPONSE

    RESPONSE_SERVER_UPLOAD_FILE_OK, //ответ от сервера об успешной загрузке файла
    RESPONSE_SERVER_DELETE_FILE_OK, //ответ от сервера об успешном удалении файла
    RESPONSE_SERVER_DOWNLOAD_FILE, //ответ от сервера скачивания файла
    RESPONSE_SERVER_REFRESH_SERVER_FILES_LIST, //ответ от сервера обновления списка файлов сервера
    RESPONSE_SERVER_ERROR_MESSAGE, //сообщение от сервера об ошибке
    RESPONSE_SERVER_AUTH_OK, //ответ от сервера об удачной авторизации пользователя


}
