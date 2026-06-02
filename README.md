# University Control Exam

Java проект по зададеното условие за провеждане на контролно чрез задължителните design patterns.

## Използвани шаблони

| Шаблон | Реализация |
|---|---|
| Singleton | `University` |
| Factory | `TaskFactory` |
| Decorator | `StudentDecorator`, `SuperConcentrationStudent`, `FastWritingStudent`, `TelepathyStudent` |
| Strategy | `ArrivalStrategy`, `RunningWithJumpingStrategy`, `TeleportationStrategy`, `SleepingInBusStrategy` |

## Типове студенти и задачи

| Тип студент | Задача |
|---|---|
| Вундеркинд | Забавна задача |
| Фитнес маниак | Непонятна задача |
| Калитко | Лесна задача |

## Стартиране

```bash
mvn clean test
mvn exec:java
```

Алтернативно проектът може да се отвори в IntelliJ IDEA като Maven проект и да се стартира класът:

```text
bg.fmi.control.exam.App
```

## Структура

```text
src/main/java/bg/fmi/control/exam
├── App.java
├── arrival
├── decorator
├── domain
├── factory
├── task
└── university
```

Кодът е оставен без коментари, защото условието ограничава максималната оценка при наличие на коментари в кода.
