# Local Config Server

This is a Spring Cloud Config Server for the locally running applications on my server. It will securely share configurations with all of them.

# Running in Development

The password for craigmiller160@gmail.com must exist as an environment variable on the machine, called GIT_HUB_PASSWORD.

Then, use the run.sh script to start the program. The deployment environment (dev/prod) must be provided as an argument, ie:

`sh run.sh dev`

# Running in Production

The following properties should be provided via environment variables: 

`spring.config.location=classpath:/config/common/,classpath:/config/prod/`
`spring.profiles.active=prod`
`spring.cloud.config.server.security.username=WHATEVER_YOU_WANT`
`spring.cloud.config.server.security.password=WHATEVER_YOU_WANT`