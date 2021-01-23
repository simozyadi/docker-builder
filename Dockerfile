FROM ubuntu:18.04

RUN apt update \
    apt install wget zip unzip

RUN wget https://releases.hashicorp.com/terraform/0.14.5/terraform_0.14.5_linux_amd64.zip 
RUN unzip terraform_0.14.5_linux_amd64.zip
RUN mv terraform /usr/local/bin

ENTRYPOINT ['terraform','--version']