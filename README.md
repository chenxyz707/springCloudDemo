# springCloudDemo

Eureka的高可用需要修改host文件添加一行
`127.0.0.1  eureka1 eureka2 eureka3`

配置中心

GitLab配置端口使用10800
>
问题：使用docker时报错“net/http: TLS handshake timeout”的解决方案
docker默认镜像拉取地址为国外仓库下载速度较慢，则会报错“net/http: TLS handshake timeout”。
此时，只需要将拉取地址改为国内镜像仓库即可。
标准格式为：
$ docker pull registry.docker-cn.com/myname/myrepo:mytag
例：
$ docker pull registry.docker-cn.com/library/ubuntu:16.04
为了永久性保留更改，您可以修改 /etc/docker/daemon.json 文件并添加上 registry-mirrors 键值。
{
"registry-mirrors": ["https://registry.docker-cn.com"]
}
修改保存后重启 Docker 以使配置生效。





docker pull gitlab/gitlab-ce:10.8.0-ce.0

docker network create chenxyz_network

`docker run -d --net=chenxyz_network -p 1443:443 -p 10800:80 --name gitlab --restart always gitlab/gitlab-ce:latest`



启动服务时提示502 Whoops, GitLab is taking too much time to respond.

解决方式：




