var Lock = function () {

    return {
        //main function to initiate the module
        init: function () {

             $.backstretch([
		        "assets/image/bg/1.jpg",
		        "assets/image/bg/2.jpg",
		        "assets/image/bg/3.jpg",
		        "assets/image/bg/4.jpg"
		        ], {
		          fade: 1000,
		          duration: 8000
		      });
        }

    };

}();