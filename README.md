# stats-service
CamPhoto Stats Spring Boot Microservice
http://35.225.98.111/comments
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
~~~bash
gcloud container clusters create-auto my-cluster1 --region us-central1 --project project1-472613
~~~

~~~bash
gcloud container clusters get-credentials my-cluster1 --region us-central1
~~~

~~~bash
kubectl create secret generic aws-creds --from-literal=aws_access_key_id=SWASWA --from-literal=aws_secret_access_key=SWASWE
~~~

~~~bash
kubectl apply -f k8s-deployment.yaml
~~~

~~~bash
kubectl get pods --watch
~~~

~~~bash
kubectl get service stats-service-lb
~~~

## camphoto.app
~~~bash
kubectl apply -f managed-cert.yaml
~~~

~~~bash
kubectl apply -f k8s-deployment.yaml
~~~

~~~bash
kubectl apply -f ingress.yaml
~~~

~~~bash
kubectl apply -f backend-config.yaml
~~~

~~~bash
kubectl describe managedcertificate camphoto-cert
~~~