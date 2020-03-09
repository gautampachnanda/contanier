mkdir -p target
cat Dockerfile_template_openjdk | sed -e "s/\${FROM}/openjdk:14/" | sed -e "s/\${MVN_VERSION}/3.5.4/"  | sed -e "s/\${GRD_VERSION}/6.2.2/"> Dockerfile && mv Dockerfile target/Dockerfile
cd target && docker build . -t gautampachnanda/openjdk:14