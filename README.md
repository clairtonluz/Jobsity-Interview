# Jobsity Interview

### How to run application

#### Running with docker

You can edit environments in `compose.yml` if you prefer, but I put some values default to help bootstrap.
```
docker compose up
```

#### Running from code

```
./gradlew bootRun
```

#### Running from de jar file
```
# build jar file
./gradlew assemble

# run application
java -jar build/libs/jobsityinterview-1.0.0.jar

# run application changing environment default
BIRTHDAYS_ORIGIN=file java -jar build/libs/jobsityinterview-1.0.0.jar
```

### Environments
- `BIRTHDAYS_ORIGIN`: default: `sqlite`, define if app will read the data from txt file or sqlite db.
  - allowed: sqlite, file
- `DB_PATH`: default: `birthdays.txt`, if `BIRTHDAYS_ORIGIN` is defined to `file`
- `SQLITE_URL`: default: `jdbc:sqlite:birthdays.db`, if `BIRTHDAYS_ORIGIN` is defined to `sqlite`
- `SQLITE_USERNAME`: default: `admin`
- `SQLITE_PASSWORD`: default: `admin`
- `EMAIL_SMTP`: default: `smtp.gmail.com`
- `EMAIL_PORT`: default: `587`
- `EMAIL_FROM`: default: `foobar20232@gmail.com`
- `EMAIL_USERNAME`: default: `foobar20232@gmail.com`
- `EMAIL_PASSWORD`: default: `xjncrabdxdyiwgzt`
- `EMAIL_AUTH`: default: `true`
- `EMAIL_START_TLS`: default: `true`
- `BIRTHDAYS_CONGRATULATES_SCHEDULER_CRON`: default: `0 0 8 * * *`
- `BIRTHDAYS_REMINDERS_SCHEDULER_CRON`: default: `0 0 8 * * *`

### Send Happy Birthday

You can access [Swagger Interface](http://localhost:8080/swagger-ui/index.html) and test endpoints

or 

```shell
# Send congratulations to all birthdays today
curl -X POST http://localhost:8080/api/birthdays/congratulates

# Send a Birthday Reminder note when it is someone else birthday:
curl -X POST http://localhost:8080/api/birthdays/reminders
```
OBS: this endpoint was created to permite trigger this task manually, but you can configure a cron task using environments, see bellow default values:

* `BIRTHDAYS_CONGRATULATES_SCHEDULER_CRON=0 0 8 * * *`
* `BIRTHDAYS_REMINDERS_SCHEDULER_CRON=0 0 8 * * *`

