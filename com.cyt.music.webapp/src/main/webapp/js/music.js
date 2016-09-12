function openNotify(t) {
	$("#notify").animate({
		height: "75px"
	}), $("#notify").html(t), $(".controls > .btn").animate({
		marginTop: "-163px"
	}), $("#divider").animate({
		marginTop: "-113px"
	}), $(".cover").animate({
		marginTop: "-345px"
	}), $(".cover-pic").animate({
		marginTop: "-284px"
	}), $("#title").animate({
		bottom: "215px"
	})
}

function closeNotify() {
	$("#notify").animate({
		height: "0px"
	}), $(".controls > .btn").animate({
		marginTop: "-88px"
	}), $("#divider").animate({
		marginTop: "-38px"
	}), $(".cover").animate({
		marginTop: "-270px"
	}), $(".cover-pic").animate({
		marginTop: "-209px"
	}), $("#title").animate({
		bottom: "140px"
	})
}

function readyPlay(t, e) {
	var i = "http://localhost:8070/web/music/queryMusicInfo.action";
	$.getJSON(i, function(i) {
		var a = null,
			n = null;
		i.start;
		var l = !1;
		"正在为您准备歌曲..." == t || "" == t || "" == e || (null == t ? (console.log("没有传递current_title，根据next_title找寻对应歌曲播放..."), $.each(i.musics, function(t, o) {
			o.title == e && (a = i.musics[t].url, n = i.musics[t].image, l = !0, console.log(i.musics[t].author + "==>" + i.musics[t].title), document.title = i.musics[t].title + " - Music+ 我们的音乐盒")
		})) : null == e ? (console.log("没有传递next_title，开始自动找寻下一首..."), $.each(i.musics, function(o, s) {
			s.title == t && (o == i.musics.length - 1 ? (a = i.musics[0].url, e = i.musics[0].title, n = i.musics[0].image, l = !0, console.log(i.musics[0].author + "==>" + i.musics[0].title), document.title = i.musics[0].title + " - Music+ 我们的音乐盒") : (a = i.musics[o + 1].url, e = i.musics[o + 1].title, n = i.musics[o + 1].image, l = !0, console.log(i.musics[o + 1].author + "==>" + i.musics[o + 1].title), document.title = i.musics[o + 1].title + " - Music+ 我们的音乐盒"))
		})) : console.log("程序刚刚发生了异常情况，请联系开发者！"));
		var o = Math.floor(Math.random() * i.musics.length);
		l || (a = i.musics[o].url, e = i.musics[o].title, n = i.musics[o].image, console.log("没有找到歌曲信息，程序选择了随机歌曲"), console.log(i.musics[o].author + "==>" + i.musics[o].title), document.title = i.musics[o].title + " - Music+ 我们的音乐盒"), $("#audio").attr("src", a), $("#title > span").text(e), $(".cover-pic img").attr({
			src: n,
			alt: e
		})
	})
}

function play() {
	audio.play(), audio.paused || ($("#playCtl .playCtl").removeClass("play"), $("#playCtl .playCtl").addClass("pause")), $("#playCtl").fadeOut()
}

function pause() {
	audio.pause(), audio.paused && ($("#playCtl .playCtl").removeClass("pause"), $("#playCtl .playCtl").addClass("play")), $("#playCtl").fadeIn()
}

function gallery() {
	window.innerWidth ? window.innerWidth : document.documentElement.clientWidth;
	var t = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight,
		e = Math.floor((t - 75 - 12) / 3),
		i = e,
		a = "http://localhost:8070/web/music/queryMusicInfo.action";
	$.getJSON(a, function(t) {
		var a = null,
			n = t.musics.length;
		console.log(n);
		var l = Math.ceil(n / 3) * (i + 3);
		$("#gallery").css({
			width: l
		}), $.each(t.musics, function(t, e) {
			a = '<div class="item"><img data-original="' + e.image + '" alt="' + e.title + '"><div class="gPlayCtl"><div class="intro"><div class="artist"><span>Artist</span>' + e.author + '</div><div class="title">' + e.title + '</div></div><a class="gPlay" href="javascript:void(0)"></a></div></div>', $("#gallery").prepend(a)
		}), $("#gallery .item").css({
			width: i,
			height: e
		}), $("#gallery .item .artist").css({
			width: i - 70
		}), $("#gallery .item .title").css({
			width: i - 55
		}), $("#gallery img").lazyload({
			effect: "fadeIn",
			placeholder: "img/cv.jpg",
			container: "#gallery",
			skip_invisible: !1
		})
	})
}
var audio = document.getElementById("audio");
$(document).ready(function() {
	function t() {
		var t = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth,
			e = window.innerHeight ? window.innerHeight : document.documentElement.clientHeight;
		$("#left-side").css({
			width: "0",
			height: e
		}), $("#main").css({
			width: t,
			height: e
		}), $("#right-side").css({
			width: "0",
			height: e
		}), $("#gallery").css("height", e - 75), $("#move-left").css("height", e - 75), $("#move-right").css("height", e - 75)
	}
	t();
	var e = $("#title > span").text();
	readyPlay(e, null), $(window).resize(function() {
		t()
	}), $("#playCtl .playCtl").click(function() {
		$(this).is(".play") ? play() : pause()
	}), $(".cover").bind({
		mouseenter: function() {
			$("#playCtl").fadeIn()
		},
		mouseleave: function() {
			audio.paused || $("#playCtl").fadeOut()
		}
	}), $(".btn.love").click(function() {
		openNotify("喜欢功能还没完成"), setTimeout(closeNotify, 3e3)
	}), $(".btn.hate").click(function() {
		openNotify("讨厌功能还没完成"), setTimeout(closeNotify, 3e3)
	}), $(".btn.repeat").click(function() {
		$("#audio").is("[loop]") ? ($("#audio").removeAttr("loop"), openNotify("你正在使用 列表循环 模式"), setTimeout(closeNotify, 3e3)) : ($("#audio").attr("loop", "true"), openNotify("你正在使用 单曲循环 模式"), setTimeout(closeNotify, 3e3)), $(this).toggleClass("hover")
	}), $(".btn.next").click(function() {
		if ($(".progress.current").animate({
				width: 0
			}), audio.paused) {
			var t = $("#title > span").text();
			readyPlay(t, null)
		} else {
			var t = $("#title > span").text();
			readyPlay(t, null), play()
		}
	}), audio.addEventListener("timeupdate", function() {
		var t = audio.currentTime,
			e = audio.duration,
			i = 100 * t / e + "%";
		$(".progress.current").css("width", i)
	}), audio.addEventListener("volumechange", function() {
		console.log("volumechange")
	}), audio.addEventListener("waiting", function() {
		console.log("waiting")
	}), audio.addEventListener("progress", function() {
		2 == audio.networkState ? (console.log("progress:加载中..."), audio.paused) : 3 == audio.networkState ? (console.log("progress:加载失败！"), openNotify("加载失败！请刷新浏览器！")) : 4 == audio.readyState && (console.log("progress:加载完成"), setTimeout(closeNotify, 500))
	}), audio.addEventListener("loadeddata", function() {
		console.log("loadeddata:已经加载完毕当前播放位置的媒体数据，开始播放"), openNotify("已经准备好歌曲，开始播放"), setTimeout(closeNotify, 3e3), play()
	}), audio.addEventListener("error", function() {
		var t = audio.error;
		switch (t.code) {
			case 1:
				console.log("error:媒体资源的下载过程被中止。"), openNotify("媒体资源的下载过程被中止。");
				break;
			case 2:
				console.log("error:网络发生故障，媒体资源的下载过程被中止。"), openNotify("网络发生故障，媒体资源的下载过程被中止。");
				break;
			case 3:
				console.log("error:解码失败。"), openNotify("解码失败。");
				break;
			case 4:
				console.log("error:媒体资源不可用或媒体格式不被支持。"), openNotify('媒体资源不可用或媒体格式不被支持。<a href="javascript:void(0)">知道了</a>')
		}
	}), audio.addEventListener("ended", function() {
		console.log("ended");
		var t = $("#title > span").text();
		readyPlay(t, null), play()
	}), $("#notify").click(function() {
		closeNotify()
	}), $("#searchInput").click(function() {
		$(this).animate({
			width: "260px"
		}, "fast"), $(".content").fadeOut(), $("#searchTip").fadeIn()
	}), $("#main").click(function(t) {
		$(t.target).is("#searchInput") || ($("#searchInput").animate({
			width: "200px"
		}, "fast"), $(".content").fadeIn(), $("#searchTip").fadeOut())
	}), $("#openGallery").click(function() {
		$("#searchTip").fadeOut(), $("#gallery").show(), $("#search").animate({
			bottom: "-78px"
		}, "slow"), $("#galleryTip").animate({
			bottom: "8px"
		}, "slow"), gallery()
	}), $("#closeGallery").click(function() {
		$("#search").animate({
			bottom: "-18px"
		}, "slow"), $("#galleryTip").animate({
			bottom: "-78px"
		}, "slow"), $("#gallery").hide(), $("#gallery").html("")
	}), $("#gallery").delegate(".item", "mouseover", function() {
		$(this).children(".gPlayCtl").show()
	}), $("#gallery").delegate(".item", "mouseout", function() {
		$(this).children(".gPlayCtl").children("a").is(".gPlay") ? $(this).children(".gPlayCtl").hide() : $(this).addClass("hover")
	}), $("#gallery").delegate("a", "click", function() {
		if ($(this).is(".gPlay")) {
			var t = $(this).prev(".intro").children(".title").text();
			readyPlay(null, t), play(), $("#gallery .item").removeClass("hover"), $("#gallery .item .gPlayCtl").hide(), $("#gallery .item .gPlayCtl a").removeClass(), $("#gallery .item .gPlayCtl a").addClass("gPlay"), $(this).removeClass("gPlay"), $(this).addClass("gPause")
		} else pause(), $(this).removeClass("gPause"), $(this).addClass("gPlay")
	}), $("#gallery").mousemove(function(t) {
		var e = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth,
			i = parseInt($("#gallery").css("width"));
		parseInt($("#gallery").css("height"));
		var a = parseInt($("#gallery").css("left"));
		t.clientX < 300 ? (console.log("left"), $("#gallery:not(:animated)").animate({
			left: 0
		}, Math.floor(-a / .1))) : t.clientX > e - 300 ? (console.log("right"), $("#gallery:not(:animated)").animate({
			left: -i + e
		}, Math.floor((i - e + a) / .1))) : (console.log("stop"), $("#gallery").stop())
	}), setInterval(function() {
		$(".cover-pic").toggleClass("rotate")
	}, 22e3), setInterval(function() {
		$(".btn.love").toggleClass("rotate")
	}, 3500), setInterval(function() {
		$(".btn.hate").toggleClass("rotate")
	}, 5500), setInterval(function() {
		$(".btn.repeat").toggleClass("rotate")
	}, 15e3), setInterval(function() {
		$(".btn.next").toggleClass("rotate")
	}, 17e3), $("#left-side").css("width", "0px"), $("#left-open").click(function() {
		var t = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth;
		"none" == $("#left-side").css("display") ? ($("#left-side").css("display", "block"), $("#left-side").animate({
			width: "400px"
		}, "fast"), $("#main").animate({
			width: t - 400
		}, "fast"), $("#right-side").animate({
			width: "0px"
		}, "fast", function() {
			$("#right-side").css("display", "none")
		})) : ($("#left-side").animate({
			width: "0px"
		}, "fast", function() {
			$("#left-side").css("display", "none")
		}), $("#main").animate({
			width: t
		}, "fast"))
	}), $("#right-side").css("width", "0px"), $("#right-open").click(function() {
		var t = window.innerWidth ? window.innerWidth : document.documentElement.clientWidth;
		"none" == $("#right-side").css("display") ? ($("#right-side").css("display", "block"), $("#right-side").animate({
			width: "400px"
		}, "fast"), $("#main").animate({
			width: t - 400
		}, "fast"), $("#left-side").animate({
			width: "0px"
		}, "fast", function() {
			$("#left-side").css("display", "none")
		})) : ($("#right-side").animate({
			width: "0px"
		}, "fast", function() {
			$("#right-side").css("display", "none")
		}), $("#main").animate({
			width: t
		}, "fast"))
	})
});