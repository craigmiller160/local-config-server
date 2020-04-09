# Local Config Server

This is a Spring Cloud Config Server for the locally running applications on my server. It will securely share configurations with all of them.

# Running in Development

The password for craigmiller160@gmail.com must exist as an environment variable on the machine, called GIT_HUB_PASSWORD.

# Running in Production

In addition to the development rule, the username and password for accessing the server must be provided through environment variables. CONFIG_SERVER_USER and CONFIG_SERVER_PASSWORD, respectively.