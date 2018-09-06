/*! UIkit 2.27.2 | http://www.getuikit.com | (c) 2014 YOOtheme | MIT License */
!function(i){var t;window.UIkit&&(t=i(UIkit)),"function"==typeof define&&define.amd&&define("uikit-slideshow-fx",["uikit"],function(){return t||i(UIkit)})}(function(i){"use strict";var t=i.slideshow.animations;i.$.extend(i.slideshow.animations,{slice:function(e,s,n,o){if(!e.data("cover"))return t.fade.apply(this,arguments);for(var r,a=i.$.Deferred(),c=Math.ceil(this.element.width()/this.options.slices),h=s.data("cover").css("background-image"),d=i.$('<li class="uk-slideshow-ghost"></li>').css({top:0,left:0,width:this.container.width(),height:this.container.height(),opacity:1,zIndex:15}),p=d.width(),l=d.height(),u="slice-up"==o?l:"0",f=0;f<this.options.slices;f++){"slice-up-down"==o&&(u=(f%2+2)%2==0?"0":l);var m,g=f==this.options.slices-1?c:c,x="rect(0px, "+g*(f+1)+"px, "+l+"px, "+c*f+"px)";m="rect(0px, "+g*(f+1)+"px, 0px, "+c*f+"px)",("slice-up"==o||"slice-up-down"==o&&(f%2+2)%2==0)&&(m="rect("+l+"px, "+g*(f+1)+"px, "+l+"px, "+c*f+"px)"),r=i.$('<div class="uk-cover-background"></div>').css({position:"absolute",top:0,left:0,width:p,height:l,"background-image":h,clip:m,opacity:0,transition:"all "+this.options.duration+"ms ease-in-out "+60*f+"ms","-webkit-transition":"all "+this.options.duration+"ms ease-in-out "+60*f+"ms"}).data("clip",x),d.append(r)}return this.container.append(d),d.children().last().on(i.support.transition.end,function(){setTimeout(function(){d.remove(),a.resolve()},0)}),d.width(),d.children().each(function(){r=i.$(this),r.css({clip:r.data("clip"),opacity:1})}),a.promise()},"slice-up":function(i,e,s){return t.slice.apply(this,[i,e,s,"slice-up"])},"slice-down":function(i,e,s){return t.slice.apply(this,[i,e,s,"slice-down"])},"slice-up-down":function(i,e,s){return t.slice.apply(this,[i,e,s,"slice-up-down"])},fold:function(e,s){if(!s.data("cover"))return t.fade.apply(this,arguments);for(var n,o=i.$.Deferred(),r=Math.ceil(this.element.width()/this.options.slices),a=s.data("cover").css("background-image"),c=i.$('<li class="uk-slideshow-ghost"></li>').css({width:s.width(),height:s.height(),opacity:1,zIndex:15}),h=s.width(),d=s.height(),p=0;p<this.options.slices;p++)n=i.$('<div class="uk-cover-background"></div>').css({position:"absolute",top:0,left:0,width:h,height:d,"background-image":a,"transform-origin":r*p+"px 0 0",clip:"rect(0px, "+r*(p+1)+"px, "+d+"px, "+r*p+"px)",opacity:0,transform:"scaleX(0.000001)",transition:"all "+this.options.duration+"ms ease-in-out "+(100+60*p)+"ms","-webkit-transition":"all "+this.options.duration+"ms ease-in-out "+(100+60*p)+"ms"}),c.prepend(n);return this.container.append(c),c.width(),c.children().first().on(i.support.transition.end,function(){setTimeout(function(){c.remove(),o.resolve()},0)}).end().css({transform:"scaleX(1)",opacity:1}),o.promise()},puzzle:function(s,n){if(!n.data("cover"))return t.fade.apply(this,arguments);for(var o,r,a,c=i.$.Deferred(),h=this,d=Math.round(this.options.slices/2),p=Math.round(n.width()/d),l=Math.round(n.height()/p),u=Math.round(n.height()/l)+1,f=n.data("cover").css("background-image"),m=i.$('<li class="uk-slideshow-ghost"></li>').css({width:this.container.width(),height:this.container.height(),opacity:1,zIndex:15}),g=this.container.width(),x=this.container.height(),w=0;l>w;w++)for(var v=0;d>v;v++)a=v==d-1?p+2:p,r=[u*w+"px",a*(v+1)+"px",u*(w+1)+"px",p*v+"px"],o=i.$('<div class="uk-cover-background"></div>').css({position:"absolute",top:0,left:0,opacity:0,width:g,height:x,"background-image":f,clip:"rect("+r.join(",")+")","-webkit-transform":"translateZ(0)",transform:"translateZ(0)"}),m.append(o);this.container.append(m);var k=e(m.children());return k.each(function(t){i.$(this).css({transition:"all "+h.options.duration+"ms ease-in-out "+(50+25*t)+"ms","-webkit-transition":"all "+h.options.duration+"ms ease-in-out "+(50+25*t)+"ms"})}).last().on(i.support.transition.end,function(){setTimeout(function(){m.remove(),c.resolve()},0)}),m.width(),k.css({opacity:1}),c.promise()},boxes:function(e,s,n,o){if(!s.data("cover"))return t.fade.apply(this,arguments);for(var r,a,c,h,d=i.$.Deferred(),p=Math.round(this.options.slices/2),l=Math.round(s.width()/p),u=Math.round(s.height()/l),f=Math.round(s.height()/u)+1,m=s.data("cover").css("background-image"),g=i.$('<li class="uk-slideshow-ghost"></li>').css({width:s.width(),height:s.height(),opacity:1,zIndex:15}),x=s.width(),w=s.height(),v=0;u>v;v++)for(h=0;p>h;h++)c=h==p-1?l+2:l,a=[f*v+"px",c*(h+1)+"px",f*(v+1)+"px",l*h+"px"],r=i.$('<div class="uk-cover-background"></div>').css({position:"absolute",top:0,left:0,opacity:1,width:x,height:w,"background-image":m,"transform-origin":a[3]+" "+a[0]+" 0",clip:"rect("+a.join(",")+")","-webkit-transform":"scale(0.0000000000000001)",transform:"scale(0.0000000000000001)"}),g.append(r);this.container.append(g);var k,b=0,y=0,$=0,I=[[]],M=g.children();for("boxes-reverse"==o&&(M=[].reverse.apply(M)),M.each(function(){I[b][y]=i.$(this),y++,y==p&&(b++,y=0,I[b]=[])}),h=0,k=0;p*u>h;h++){k=h;for(var z=0;u>z;z++)k>=0&&p>k&&I[z][k].css({transition:"all "+this.options.duration+"ms linear "+(50+$)+"ms","-webkit-transition":"all "+this.options.duration+"ms linear "+(50+$)+"ms"}),k--;$+=100}return M.last().on(i.support.transition.end,function(){setTimeout(function(){g.remove(),d.resolve()},0)}),g.width(),M.css({"-webkit-transform":"scale(1)",transform:"scale(1)"}),d.promise()},"boxes-reverse":function(i,e,s){return t.boxes.apply(this,[i,e,s,"boxes-reverse"])},"random-fx":function(){var i=["slice-up","fold","puzzle","slice-down","boxes","slice-up-down","boxes-reverse"];return this.fxIndex=(void 0===this.fxIndex?-1:this.fxIndex)+1,i[this.fxIndex]||(this.fxIndex=0),t[i[this.fxIndex]].apply(this,arguments)}});var e=function(i){for(var t,e,s=i.length;s;t=parseInt(Math.random()*s),e=i[--s],i[s]=i[t],i[t]=e);return i};return i.slideshow.animations});