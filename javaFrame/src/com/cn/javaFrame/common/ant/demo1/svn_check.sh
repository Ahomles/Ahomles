case $1 in
        esb)
	cd $HOME/deploy_oppf/bin
        svn co --username oppfdeploy --password oppfdeploy-123 http://10.11.20.110/svn/AIOPENPLATFORM/branches/aiopenplatform/aiesb ../svn/aiesb
        ;;
        opr)
	cd $HOME/deploy_oppf/bin
        svn co --username oppfdeploy --password oppfdeploy-123 http://10.11.20.110/svn/AIOPENPLATFORM/branches/aiopenplatform/aopopr ../svn/aopopr
        ;;
        dev)
	cd $HOME/deploy_oppf/bin
        svn co --username oppfdeploy --password oppfdeploy-123 http://10.11.20.110/svn/AIOPENPLATFORM/branches/aiopenplatform/aopdev ../svn/aopdev
        ;;
        auth)
        cd $HOME/deploy_oppf/bin
        svn co --username oppfdeploy --password oppfdeploy-123 http://10.11.20.110/svn/AIOPENPLATFORM/branches/aiopenplatform/aop_oauth ../svn/aopoauth
        ;;
        *)
	echo "请输入参数，如例： usage esb/opr/dev/auth"
        ;;
esac