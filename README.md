# Jobsity Interview

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

OBS: there is `birthdays.txt` file in current path. But you can replace to another or set `DB_PATH` variable to use
another file.

```
# build jar file
./gradlew assemble

# run application
java -jar build/libs/jobsityinterview-1.0.0.jar

# run application using another db file.
DB_PATH=birthdays2.txt java -jar build/libs/jobsityinterview-1.0.0.jar
```

### Configure birthdays

* There is a file called `birthdays.txt`, you can replace this by your file. 
* By default, the application looking for this file in the directory that you call application to run, but you can
  inform another path by set environment `DB_PATH`.

### How to run application


