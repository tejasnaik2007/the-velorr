package com.leema.web;

/** The complete stylesheet, embedded in Java. ORIGINAL is the original page's &lt;style&gt; block, unchanged. */
public final class Css {
    private Css() {}

    /** Hero video size (image/hero page.mp4) – used to place the corner badge exactly like the original script. */
    public static final int VIDEO_W = 848, VIDEO_H = 480;

    public static final String ORIGINAL = """
:root{
  --tide:#0d2b33; --tide-2:#14404a; --foam:#f5f0e4; --sand:#e6d3ae; --paper:#ece2cc;
  --brass:#d29b3c; --wa:#1faa59;
  --display:"Fraunces",Georgia,serif; --body:"Instrument Sans",system-ui,sans-serif;
}
*{box-sizing:border-box;margin:0;padding:0}
html{scroll-behavior:smooth}
body{font-family:var(--body);background:var(--foam);color:var(--tide);line-height:1.6;font-size:17px;overflow-x:hidden}
a{color:inherit}
:focus-visible{outline:3px solid var(--brass);outline-offset:3px}
.wrap{width:min(1180px,92vw);margin:0 auto}

/* buttons */
.cta{display:flex;flex-wrap:wrap;gap:12px}
.btn{display:inline-flex;align-items:center;padding:14px 26px;border-radius:99px;font-weight:600;text-decoration:none;font-size:1rem;border:0;cursor:pointer;transition:transform .2s,background .2s,color .2s}
.btn:hover{transform:translateY(-2px)}
.btn.wa{background:var(--wa);color:#fff}
.btn.ghost{border:1.5px solid rgba(245,240,228,.75);color:var(--foam)}
.btn.ghost:hover{background:var(--foam);color:var(--tide)}
.btn.dark{background:var(--tide);color:var(--foam)}
.btn.line{border:1.5px solid var(--tide)}
.btn.line:hover{background:var(--tide);color:var(--foam)}

/* nav */
.nav{position:fixed;inset:0 0 auto 0;z-index:30;display:flex;justify-content:space-between;align-items:center;padding:16px 4vw;color:var(--foam);transition:background .3s,padding .3s}
.nav.solid{background:rgba(13,43,51,.92);backdrop-filter:blur(8px);padding:11px 4vw}
.nav b{font-family:var(--display);font-weight:600;font-size:1.2rem}
.nav .links{display:none;gap:28px;font-weight:500}
.nav .links a{text-decoration:none;opacity:.9}
.nav .links a:hover{opacity:1;color:var(--brass)}
.nav .call{text-decoration:none;font-weight:600;border:1.5px solid rgba(245,240,228,.65);padding:8px 16px;border-radius:99px;font-size:.95rem}
.nav .call:hover{background:var(--foam);color:var(--tide)}
@media(min-width:800px){.nav .links{display:flex}}

/* hero video */
.hero{position:relative;height:100vh;height:100svh;min-height:520px;overflow:hidden;color:var(--foam);background:linear-gradient(160deg,var(--tide-2),var(--tide));perspective:1200px}
.vwrap{position:absolute;inset:0;transform:rotateX(var(--rx,0deg)) rotateY(var(--ry,0deg)) scale(var(--s,1.1));transition:transform .25s ease-out;will-change:transform}
.vwrap video{width:100%;height:100%;object-fit:cover;display:block}
.mark{position:absolute;z-index:2;display:none;place-items:center;border-radius:50%;background:rgba(13,43,51,.45);-webkit-backdrop-filter:blur(18px);backdrop-filter:blur(18px);color:var(--brass);font-family:var(--display);font-weight:800;pointer-events:none}
.hero::after{content:"";position:absolute;inset:0;background:linear-gradient(180deg,rgba(13,43,51,.5) 0%,rgba(13,43,51,0) 25%,rgba(13,43,51,0) 50%,rgba(13,43,51,.85) 100%)}
.hero .content{position:absolute;z-index:3;left:0;right:0;bottom:0;padding-bottom:9vh}
.hero h1{font-family:var(--display);font-weight:800;font-size:clamp(3rem,11vw,8rem);line-height:.95;letter-spacing:-.025em;text-shadow:0 2px 30px rgba(13,43,51,.5)}
.hero p{font-size:clamp(1.05rem,2.4vw,1.4rem);max-width:30ch;margin:16px 0 28px;color:var(--sand);text-shadow:0 1px 14px rgba(13,43,51,.6)}
.hero .reveal{animation:rise 1s cubic-bezier(.2,.7,.2,1) both}
.hero .d2{animation-delay:.15s}.hero .d3{animation-delay:.3s}
@keyframes rise{from{opacity:0;transform:translateY(30px)}to{opacity:1;transform:none}}
.cue{position:absolute;z-index:3;left:50%;bottom:3vh;transform:translateX(-50%);font-size:.85rem;color:var(--sand)}

.times{background:var(--brass);color:var(--tide)}
.times .wrap{display:flex;flex-wrap:wrap;gap:6px 44px;padding:16px 0;font-weight:600}
.times span{font-weight:500}

/* rooms */
.intro{padding:96px 0 24px}
.intro h2,.gal h2,.where h2{font-family:var(--display);font-weight:600;font-size:clamp(2.2rem,5.5vw,3.8rem);line-height:1.08}
.intro p{margin-top:12px;max-width:44ch;color:#3b5b63}
.room{padding:56px 0}
.room:nth-of-type(even){background:var(--paper)}
.room .wrap{display:grid;gap:28px;align-items:center}
.shot{position:relative;border-radius:6px;overflow:hidden;aspect-ratio:4/3;background:linear-gradient(150deg,var(--tide-2),var(--tide));clip-path:inset(0 0 100% 0);transition:clip-path 1.1s cubic-bezier(.2,.7,.2,1)}
.shot img{width:100%;height:100%;object-fit:cover;display:block;transform:scale(1.18);transition:transform 1.6s cubic-bezier(.2,.7,.2,1)}
.shot.empty::after{content:attr(data-name);position:absolute;inset:0;display:grid;place-items:center;font-family:var(--display);font-size:clamp(2rem,6vw,4rem);font-weight:800;color:rgba(230,211,174,.35);text-align:center;padding:20px}
.room.in .shot{clip-path:inset(0)}
.room.in .shot img{transform:scale(1)}
.info .no{font-family:var(--display);color:var(--brass);font-weight:600;font-size:1.1rem;margin-bottom:6px}
.info h3{font-family:var(--display);font-weight:800;font-size:clamp(2.2rem,5.5vw,3.6rem);line-height:1.02;letter-spacing:-.015em}
.info .desc{margin:10px 0 18px;color:#3b5b63;font-size:1.1rem}
.info .price{font-family:var(--display);font-weight:800;font-size:clamp(2.4rem,6vw,3.8rem);color:var(--brass);line-height:1}
.info .price small{font-family:var(--body);font-weight:500;font-size:.95rem;color:#3b5b63;margin-left:8px}
.info .btn{margin-top:22px}
.info{opacity:0;transform:translateY(26px);transition:opacity .9s .25s,transform .9s .25s}
.room.in .info{opacity:1;transform:none}
@media(min-width:860px){
  .room{padding:84px 0}
  .room .wrap{grid-template-columns:1.35fr 1fr;gap:64px}
  .room.flip .shot{order:2}
  .room.flip .wrap{grid-template-columns:1fr 1.35fr}
}

/* gallery: two rows moving in opposite directions */
.gal{background:var(--tide);color:var(--foam);padding:96px 0 90px;overflow:hidden;display:none}
.gal.on{display:block}
.gal .head{margin-bottom:36px}
.gal p{color:var(--sand);margin-top:10px}
.marq{overflow:hidden;margin-top:14px}
.track{display:flex;width:max-content;animation:toLeft 55s linear infinite}
.track.rev{animation-name:toRight}
.marq:hover .track{animation-play-state:paused}
.track figure{flex:none;width:min(78vw,380px);aspect-ratio:4/3;margin-right:14px;border-radius:6px;overflow:hidden}
.track img{width:100%;height:100%;object-fit:cover;display:block}
@keyframes toLeft{to{transform:translateX(-50%)}}
@keyframes toRight{from{transform:translateX(-50%)}to{transform:translateX(0)}}

/* where */
.where{padding:96px 0}
.where .cols{display:grid;gap:36px;margin-top:28px}
@media(min-width:760px){.where .cols{grid-template-columns:1fr 1fr}}
.where dl div{padding:16px 0;border-top:1px solid rgba(13,43,51,.2)}
.where dt{font-weight:600}
.where dd{color:#3b5b63}
.where .btns{display:flex;flex-wrap:wrap;gap:12px;margin-top:8px}
footer{background:var(--tide);color:var(--sand);padding:34px 0;font-size:.95rem}
footer .wrap{display:flex;flex-wrap:wrap;justify-content:space-between;gap:10px}
.floats{position:fixed;right:16px;bottom:16px;z-index:25;display:flex;flex-direction:column;gap:10px;align-items:flex-end}
.float{color:#fff;text-decoration:none;font-weight:600;padding:14px 20px;border-radius:99px;box-shadow:0 8px 24px rgba(0,0,0,.28)}
.float.wa{background:var(--wa)}
.float.call{background:var(--brass);color:var(--tide)}
.btn.call{background:var(--brass);color:var(--tide)}
.info .acts{display:flex;flex-wrap:wrap;gap:12px;margin-top:22px}
.info .acts .btn{margin-top:0}

/* ---------- mobile fixes ---------- */
@media(max-width:799px){
  body{font-size:16px;padding-bottom:calc(76px + env(safe-area-inset-bottom))}
  .nav b{font-size:1.05rem}
  .nav .call{padding:7px 13px;font-size:.88rem}
  .hero::after{background:linear-gradient(180deg,rgba(13,43,51,.55) 0%,rgba(13,43,51,0) 20%,rgba(13,43,51,0) 38%,rgba(13,43,51,.92) 100%)}
  .hero h1{font-size:clamp(2.3rem,11.5vw,3.3rem);line-height:1}
  .hero p{font-size:1rem;max-width:26ch;margin:10px 0 18px}
  .hero .cta{display:grid;grid-template-columns:1fr 1fr;gap:10px}
  .hero .cta .btn{justify-content:center;padding:13px 10px;font-size:.98rem}
  .hero .cta .btn.ghost{grid-column:1/-1}
  .cue{display:none}
  /* phone: whole video frame on top, text right under it (no empty gap) */
  .hero{height:auto;min-height:0;display:flex;flex-direction:column;padding-top:66px;background:linear-gradient(180deg,#0d2b33 0%,#14404a 100%)}
  .vwrap{position:relative;inset:auto;height:auto;transform:none!important;transition:none}
  .vwrap video{height:auto;object-fit:contain}
  .hero::after{background:none}
  .hero .content{position:relative;left:auto;right:auto;bottom:auto;padding:22px 0 30px}
  .times .wrap{gap:4px 28px;padding:13px 0;font-size:.95rem}
  .times .hide-m{display:none}
  .intro{padding:60px 0 10px}
  .room{padding:38px 0}
  .info .acts .btn{flex:1;justify-content:center;padding:13px 10px}
  .gal{padding:64px 0 60px}
  .where{padding:64px 0}
  .where .btns .btn{flex:1 1 140px;justify-content:center}
  /* bottom action bar instead of floating pills */
  .floats{left:0;right:0;bottom:0;flex-direction:row;gap:10px;padding:10px 12px calc(10px + env(safe-area-inset-bottom));background:rgba(13,43,51,.96);transform:translateY(110%);transition:transform .35s}
  .floats.show{transform:none}
  .float{flex:1;text-align:center;border-radius:12px;padding:13px 10px;box-shadow:none}
}

@media(prefers-reduced-motion:reduce){
  html{scroll-behavior:auto}
  .hero .reveal{animation:none}
  .vwrap{transition:none}
  .shot{clip-path:none;transition:none}.shot img{transform:none;transition:none}
  .info{opacity:1;transform:none;transition:none}
  .marq{overflow-x:auto}.track{animation:none}
}
""";

    public static final String NO_JS = """

/* ===== no-JavaScript replacements (pure CSS) for what the original page script did ===== */
@property --s{syntax:'<number>';inherits:false;initial-value:1.1}
@supports (animation-timeline:scroll()){
  /* nav turns solid once the page is scrolled ~60px */
  .nav{animation:navSolid linear both;animation-timeline:scroll(root);animation-range:50px 70px}
  /* hero video zooms and the hero text fades/moves up while scrolling the first screen */
  .vwrap{animation:heroZoom linear both;animation-timeline:scroll(root);animation-range:0px 100vh}
  .hero .content{animation:heroFade linear both;animation-timeline:scroll(root);animation-range:0px 100vh}
  /* phone: bottom action bar slides in after 60% of a screen */
  @media(max-width:799px){.floats{animation:floatsIn linear both;animation-timeline:scroll(root);animation-range:60vh calc(60vh + 40px)}}
}
@keyframes navSolid{from{background:rgba(13,43,51,0);-webkit-backdrop-filter:blur(0);backdrop-filter:blur(0);padding:16px 4vw}to{background:rgba(13,43,51,.92);-webkit-backdrop-filter:blur(8px);backdrop-filter:blur(8px);padding:11px 4vw}}
@keyframes heroZoom{from{--s:1.1}to{--s:1.22}}
@keyframes heroFade{0%{opacity:1;transform:translateY(0)}66.667%{opacity:0;transform:translateY(-33.333px)}100%{opacity:0;transform:translateY(-50px)}}
@keyframes floatsIn{from{transform:translateY(110%)}to{transform:none}}
@supports not (animation-timeline:scroll()){@media(max-width:799px){.floats{transform:none}}}

/* rooms reveal as they scroll into view */
.room{view-timeline:--room block}
@supports (animation-timeline:view()){@media(prefers-reduced-motion:no-preference){
  .shot{animation:shotIn linear both;animation-timeline:--room;animation-range:entry 5% entry 40%;animation-timing-function:cubic-bezier(.2,.7,.2,1)}
  .shot img{animation:imgIn linear both;animation-timeline:--room;animation-range:entry 5% entry 40%;animation-timing-function:cubic-bezier(.2,.7,.2,1)}
  .info{animation:infoIn linear both;animation-timeline:--room;animation-range:entry 12% entry 50%}
}}
@keyframes shotIn{from{clip-path:inset(0 0 100% 0)}to{clip-path:inset(0)}}
@keyframes imgIn{from{transform:scale(1.18)}to{transform:scale(1)}}
@keyframes infoIn{from{opacity:0;transform:translateY(26px)}to{opacity:1;transform:none}}
@supports not (animation-timeline:view()){.shot{clip-path:inset(0)}.shot img{transform:scale(1)}.info{opacity:1;transform:none}}

/* round "V" badge over the video's bottom-right corner (position computed in CSS from the video size) */
.vwrap{container-type:size}
.mark{display:grid;--W:100cqw;--H:100cqh;--dw:max(var(--W),calc(var(--H) * VW / VH));--dh:max(var(--H),calc(var(--W) * VH / VW));
  --sz:clamp(30px,calc(var(--dw) * .07),130px);width:var(--sz);height:var(--sz);font-size:calc(var(--sz) * .45);
  left:calc((var(--W) - var(--dw)) / 2 + var(--dw) * .907 - var(--sz) / 2);top:calc((var(--H) - var(--dh)) / 2 + var(--dh) * .84 - var(--sz) / 2)}
@media(max-width:799px){
  .vwrap{container-type:inline-size}
  .mark{--dw:var(--W);--dh:calc(var(--W) * VH / VW);--sz:clamp(30px,calc(var(--W) * .07),130px);left:calc(var(--W) * .907 - var(--sz) / 2);top:calc(var(--dh) * .84 - var(--sz) / 2)}
}
""".replace("VW", String.valueOf(VIDEO_W)).replace("VH", String.valueOf(VIDEO_H));

    public static final String STYLE = ORIGINAL + NO_JS;
}
