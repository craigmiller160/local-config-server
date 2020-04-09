#!/bin/sh

mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.config.location=classpath:/config/common/"