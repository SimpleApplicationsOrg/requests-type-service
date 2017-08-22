pkg_name=type-service
pkg_origin=mateusf777
pkg_version="0.0.1-SNAPSHOT"
pkg_maintainer="Mateus Fernandes"
pkg_license=('Apache-2.0')
pkg_deps=( "core/jdk8" )
pkg_build_deps=( core/gradle )
pkg_bin_dirs=(bin)
pkg_exports=(
   [port]=srv.port
)
pkg_exposes=( port )
pkg_svc_user=root
pkg_svc_group=root

do_build() {
	export JAVA_HOME=$(hab pkg path core/jdk8)
	./gradlew build -x test
}

do_install() {
        cp build/libs/${pkg_name}-${pkg_version}.jar ${pkg_prefix}/bin/type-service.jar
}
