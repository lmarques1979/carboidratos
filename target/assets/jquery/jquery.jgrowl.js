(function(a){var f=!1===a.support.boxModel&&a.support.objectAll&&a.support.leadingWhitespace;a.jGrowl=function(d,b){0==a("#jGrowl").size()&&a('<div id="jGrowl"></div>').addClass(b&&b.position?b.position:a.jGrowl.defaults.position).appendTo("body");a("#jGrowl").jGrowl(d,b)};a.fn.jGrowl=function(d,b){if(a.isFunction(this.each)){var e=arguments;return this.each(function(){void 0==a(this).data("jGrowl.instance")&&(a(this).data("jGrowl.instance",a.extend(new a.fn.jGrowl,{notifications:[],element:null,
interval:null})),a(this).data("jGrowl.instance").startup(this));a.isFunction(a(this).data("jGrowl.instance")[d])?a(this).data("jGrowl.instance")[d].apply(a(this).data("jGrowl.instance"),a.makeArray(e).slice(1)):a(this).data("jGrowl.instance").create(d,b)})}};a.extend(a.fn.jGrowl.prototype,{defaults:{pool:0,header:"",group:"",sticky:!1,position:"top-right",glue:"after",theme:"default",themeState:"highlight",corners:"10px",check:250,life:3E3,closeDuration:"normal",openDuration:"normal",easing:"swing",
closer:!0,closeTemplate:"&times;",closerTemplate:"<div>[ close all ]</div>",log:function(){},beforeOpen:function(){},afterOpen:function(){},open:function(){},beforeClose:function(){},close:function(){},animateOpen:{opacity:"show"},animateClose:{opacity:"hide"}},notifications:[],element:null,interval:null,create:function(d,b){b=a.extend({},this.defaults,b);"undefined"!==typeof b.speed&&(b.openDuration=b.speed,b.closeDuration=b.speed);this.notifications.push({message:d,options:b});b.log.apply(this.element,
[this.element,d,b])},render:function(d){var b=this,e=d.message,c=d.options;c.themeState=""==c.themeState?"":"ui-state-"+c.themeState;d=a("<div/>").addClass("jGrowl-notification "+c.themeState+" ui-corner-all"+(void 0!=c.group&&""!=c.group?" "+c.group:"")).append(a("<div/>").addClass("jGrowl-close").html(c.closeTemplate)).append(a("<div/>").addClass("jGrowl-header").html(c.header)).append(a("<div/>").addClass("jGrowl-message").html(e)).data("jGrowl",c).addClass(c.theme).children("div.jGrowl-close").bind("click.jGrowl",
function(){a(this).parent().trigger("jGrowl.beforeClose")}).parent();a(d).bind("mouseover.jGrowl",function(){a("div.jGrowl-notification",b.element).data("jGrowl.pause",!0)}).bind("mouseout.jGrowl",function(){a("div.jGrowl-notification",b.element).data("jGrowl.pause",!1)}).bind("jGrowl.beforeOpen",function(){!1!==c.beforeOpen.apply(d,[d,e,c,b.element])&&a(this).trigger("jGrowl.open")}).bind("jGrowl.open",function(){!1!==c.open.apply(d,[d,e,c,b.element])&&("after"==c.glue?a("div.jGrowl-notification:last",
b.element).after(d):a("div.jGrowl-notification:first",b.element).before(d),a(this).animate(c.animateOpen,c.openDuration,c.easing,function(){!1===a.support.opacity&&this.style.removeAttribute("filter");null!==a(this).data("jGrowl")&&(a(this).data("jGrowl").created=new Date);a(this).trigger("jGrowl.afterOpen")}))}).bind("jGrowl.afterOpen",function(){c.afterOpen.apply(d,[d,e,c,b.element])}).bind("jGrowl.beforeClose",function(){!1!==c.beforeClose.apply(d,[d,e,c,b.element])&&a(this).trigger("jGrowl.close")}).bind("jGrowl.close",
function(){a(this).data("jGrowl.pause",!0);a(this).animate(c.animateClose,c.closeDuration,c.easing,function(){a.isFunction(c.close)?!1!==c.close.apply(d,[d,e,c,b.element])&&a(this).remove():a(this).remove()})}).trigger("jGrowl.beforeOpen");""!=c.corners&&void 0!=a.fn.corner&&a(d).corner(c.corners);1<a("div.jGrowl-notification:parent",b.element).size()&&0==a("div.jGrowl-closer",b.element).size()&&!1!==this.defaults.closer&&a(this.defaults.closerTemplate).addClass("jGrowl-closer "+this.defaults.themeState+
" ui-corner-all").addClass(this.defaults.theme).appendTo(b.element).animate(this.defaults.animateOpen,this.defaults.speed,this.defaults.easing).bind("click.jGrowl",function(){a(this).siblings().trigger("jGrowl.beforeClose");a.isFunction(b.defaults.closer)&&b.defaults.closer.apply(a(this).parent()[0],[a(this).parent()[0]])})},update:function(){a(this.element).find("div.jGrowl-notification:parent").each(function(){void 0!=a(this).data("jGrowl")&&void 0!==a(this).data("jGrowl").created&&a(this).data("jGrowl").created.getTime()+
parseInt(a(this).data("jGrowl").life)<(new Date).getTime()&&!0!==a(this).data("jGrowl").sticky&&(void 0==a(this).data("jGrowl.pause")||!0!==a(this).data("jGrowl.pause"))&&a(this).trigger("jGrowl.beforeClose")});0<this.notifications.length&&(0==this.defaults.pool||a(this.element).find("div.jGrowl-notification:parent").size()<this.defaults.pool)&&this.render(this.notifications.shift());2>a(this.element).find("div.jGrowl-notification:parent").size()&&a(this.element).find("div.jGrowl-closer").animate(this.defaults.animateClose,
this.defaults.speed,this.defaults.easing,function(){a(this).remove()})},startup:function(d){this.element=a(d).addClass("jGrowl").append('<div class="jGrowl-notification"></div>');this.interval=setInterval(function(){a(d).data("jGrowl.instance").update()},parseInt(this.defaults.check));f&&a(this.element).addClass("ie6")},shutdown:function(){a(this.element).removeClass("jGrowl").find("div.jGrowl-notification").trigger("jGrowl.close").parent().empty();clearInterval(this.interval)},close:function(){a(this.element).find("div.jGrowl-notification").each(function(){a(this).trigger("jGrowl.beforeClose")})}});
a.jGrowl.defaults=a.fn.jGrowl.prototype.defaults})(jQuery);