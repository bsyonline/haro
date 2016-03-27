from fabric.api import run, sudo
from fabric.context_managers import cd
from fabric.operations import put

def deploy(module, version):
    base_dir = "/opt/%s" % module
    releases_dir = "%s/releases" % base_dir
    shared_dir = "%s/shared" % base_dir
    current_path = "%s/current" % base_dir

    current_version = "%s-%s" % (module, version)
    package_name = "%s.tar.gz" % current_version
    local_path = "target/%s" % package_name

    put(local_path, "/tmp")
    with cd(releases_dir):
        run("tar -xf /tmp/%s && rm -fr /tmp/%s" % (package_name, package_name))

    run("rm -f %s && ln -s %s/%s %s" % (current_path, releases_dir, current_version, current_path))
    run("rm -rf %s/logs && ln -s %s/logs %s/logs" % (current_path, shared_dir, current_path))
    run("rm -rf %s/etc && ln -s %s/etc %s/etc" % (current_path, shared_dir, current_path))
    run("rm -rf %s/data && ln -s %s/data %s/data" % (current_path, shared_dir, current_path))
    run("rm -rf %s/var && ln -s %s/var %s/var" % (current_path, shared_dir, current_path))
    run("rm -rf %s/run && ln -s %s/run %s/run" % (current_path, shared_dir, current_path))

    with cd(releases_dir):
        sudo("/bin/ls -1 -t|sed '1,10d'|grep %s- | xargs sudo rm -rf" % module)

    sudo("chown -R rolex.rolex /opt/%s" % module)
