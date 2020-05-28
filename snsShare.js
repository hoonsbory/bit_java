const url = this.state.subUrl
        const app_id = "2473764549612950"
        var popupWidth = 500;
        var popupHeight = 500;

        var popupX = (window.screen.width / 2) - (popupWidth / 2);

        var popupY = (window.screen.height / 2) - (popupHeight / 2);
        var size = 'status=no, height=' + popupHeight + ', width=' + popupWidth + ', left=' + popupX + ', top=' + popupY;
        function facebook() {
            window.open('http://www.facebook.com/sharer/sharer.php?u=' + url, "name", size)
        }
        function kakaoStory() {
            window.open('https://story.kakao.com/share?url=' + url, "name", size)
        }
        function twitter() {
            window.open('http://twitter.com/intent/tweet?text=' + url, "name", size)
        }
        function naver() {
            window.open('http://share.naver.com/web/shareView.nhn?url=' + url + "&title=심콩", "name", size)
        }
        function line() {
            window.open('https://social-plugins.line.me/lineit/share?url=' + url, "name", size)
        }
        function band() {
            window.open('https://band.us/plugin/share?body=' + url, "name", size)
        }
        function fbmessage() {
            //모바일기기
            if (navigator.userAgent.indexOf('Mobile') !== -1) {
                window.open('fb-messenger://share?link=' + encodeURIComponent(url) + '&app_id=' + encodeURIComponent(app_id));
            }else{
            window.open('http://www.facebook.com/dialog/send?app_id=' + app_id + '&link=' + url + '&redirect_uri=' + url, "name", 'status=no, height=' + 600 + ', width=' + 900 + ', left=' + popupX + ', top=' + popupY)
            }
        }