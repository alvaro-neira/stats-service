# stats-service
CamPhoto Stats Spring Boot Microservice

https://stats-service-928626821112.us-central1.run.app/comments

## Local Docker
~~~bash
docker build --tag stats-service .
~~~

~~~bash
docker run -p 5000:5000 -v ~/.aws:/root/.aws stats-service
~~~

## Docker on GCP
~~~bash
gcloud artifacts repositories create my-repo --repository-format=docker --location=us-central1
~~~

~~~bash
gcloud auth configure-docker us-central1-docker.pkg.dev
~~~

~~~bash
docker tag stats-service us-central1-docker.pkg.dev/project1-472613/my-repo/stats-service:v1
~~~

~~~bash
docker push us-central1-docker.pkg.dev/project1-472613/my-repo/stats-service:v1
~~~

## Kubernetes