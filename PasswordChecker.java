public class PasswordChecker {

    private int minLength = -1;
    private int maxRepeats = -1;

    // Флаги, показывающие, были ли настройки установлены
    private boolean isMinLengthSet = false;
    private boolean isMaxRepeatsSet = false;

    // --- Сеттеры ---

    public void setMinLength(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Минимальная длина пароля не может быть отрицательной.");
        }
        this.minLength = length;
        this.isMinLengthSet = true;
    }

    public void setMaxRepeats(int repeats) {
        // Условие для MaxRepeats: отрицательное или 0 недопустимо
        if (repeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторений должно быть положительным числом (> 0).");
        }
        this.maxRepeats = repeats;
        this.isMaxRepeatsSet = true;
    }

    // --- Метод проверки ---

    public boolean verify(String password) {
        // Проверка состояния (IllegalStateException)
        if (!isMinLengthSet || !isMaxRepeatsSet) {
            throw new IllegalStateException("Не выставлены настройки чекера. Установите setMinLength и setMaxRepeats.");
        }

        // 1. Проверка минимальной длины
        if (password.length() < minLength) {
            // В задании требуется только true/false, вывод сообщений лучше оставить за пределами verify()
            // System.out.println("Не подходит длина пароля!");
            return false;
        }

        // Пароль пустой? Если минимальная длина 0, то true, иначе уже отвалилось выше.
        if (password.isEmpty()) {
            return true;
        }

        // 2. Проверка повторений подряд
        int currentRepeatCount = 1;
        char previousChar = password.charAt(0);

        // Итерируемся, начиная со второго символа
        for (int i = 1; i < password.length(); i++) {
            char currentChar = password.charAt(i);

            if (currentChar == previousChar) {
                currentRepeatCount++;
                // Сначала увеличиваем счетчик, потом проверяем, превышает ли он максимум
                if (currentRepeatCount > maxRepeats) {
                    // System.out.println("Превышено макс. кол-во повторений символа!");
                    return false;
                }
            } else {
                // Если символ изменился, сбрасываем счетчик и обновляем символ
                previousChar = currentChar;
                currentRepeatCount = 1;
            }
        }

        return true; // Пароль прошел все проверки
    }
}