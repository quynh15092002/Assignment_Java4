var url = location.href;
var login_filter_toAddCart = url.search("login_when_addtocart");
console.log("ám")
if(login_filter_toAddCart > 0){
	alert("Mời đăng nhập ");
}