package com.leema.web;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.leema.web.Site.*;

/** Builds the one-page site in Java. Everything the original script generated is rendered on the server. */
@RestController
public class PageController {

    @GetMapping(value = "/css/style.css", produces = "text/css;charset=UTF-8")
    public ResponseEntity<String> css() {
        return ResponseEntity.ok().cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS)).body(Css.STYLE);
    }

    @GetMapping(value = {"/", "/index.html"}, produces = "text/html;charset=UTF-8")
    public String home() {
        String bookWa = esc(wa(BOOK_MSG));
        StringBuilder h = new StringBuilder(24000);
        h.append("""
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>The Velorr | Rooms from ₹999 a night</title>
<meta name="description" content="The Velorr lodge. AC, non-AC, triple, four-bed rooms, hall, homestay and budget rooms. Check-in 12 noon. Book on WhatsApp.">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fraunces:opsz,wght@9..144,400;9..144,600;9..144,800&family=Instrument+Sans:wght@400;500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<nav class="nav" id="nav">
  <b>The Velorr</b>
  <div class="links"><a href="#rooms">Rooms</a><a href="#gallery">Gallery</a><a href="#contact">Contact</a></div>
""");
        h.append("  <a class=\"call\" href=\"").append(TEL).append("\">Call ").append(esc(NAV_DISPLAY)).append("</a>\n</nav>\n\n");
        h.append("""
<header class="hero" id="hero">
  <div class="vwrap" id="vwrap">
    <video autoplay muted loop playsinline preload="auto" aria-hidden="true">
      <source src="image/hero%20page.mp4" type="video/mp4">
      <source src="image/hero%20page.MP4" type="video/mp4">
      <source src="image/hero%20page.webm" type="video/webm">
      <source src="image/hero%20page.mov" type="video/quicktime">
    </video>
    <div class="mark" id="mark" aria-hidden="true">V</div>
  </div>
  <div class="content" id="heroText"><div class="wrap">
    <h1 class="reveal">The Velorr</h1>
    <p class="reveal d2">Rooms from ₹999 a night. Check in at 12 noon.</p>
    <div class="cta reveal d3">
""");
        h.append("      <a class=\"btn wa\" id=\"heroWa\" href=\"").append(bookWa).append("\">Book on WhatsApp</a>\n")
         .append("      <a class=\"btn call\" href=\"").append(TEL).append("\">Call now</a>\n")
         .append("      <a class=\"btn ghost\" href=\"#rooms\">Explore rooms</a>\n    </div>\n  </div></div>\n  <div class=\"cue\">Scroll</div>\n</header>\n\n");
        h.append("<div class=\"times\"><div class=\"wrap\">\n  <div>Check-in <span>12 noon</span></div>\n  <div>Check-out <span>12 noon</span></div>\n")
         .append("  <div class=\"hide-m\">Call or WhatsApp <span>").append(esc(DISPLAY)).append("</span></div>\n</div></div>\n\n");
        h.append("""
<section class="intro" id="rooms"><div class="wrap">
  <h2>Choose your room</h2>
  <p>Seven ways to stay, from budget rooms to a full hall. Prices are per night.</p>
</div></section>

""");
        // room sections, one by one
        h.append("<div id=\"roomList\">");
        List<Room> all = all();
        for (int i = 0; i < all.size(); i++) h.append(section(all.get(i), i, all.size()));
        h.append("</div>\n\n");

        // gallery rows (only shown when at least one photo exists, like the original)
        List<String> ok = new ArrayList<>();
        for (String g : GALLERY) { String u = probe(g); if (u != null) ok.add(u); }
        List<String> rev = new ArrayList<>(ok);
        Collections.reverse(rev);
        h.append("<section class=\"gal").append(ok.isEmpty() ? "" : " on").append("\" id=\"gallery\">\n")
         .append("  <div class=\"wrap head\">\n    <h2>The lodge in pictures</h2>\n    <p>Every room and space, in one glance.</p>\n  </div>\n")
         .append("  <div class=\"marq\"><div class=\"track\" id=\"row1\">").append(ok.isEmpty() ? "" : figures(ok) + figures(ok)).append("</div></div>\n")
         .append("  <div class=\"marq\"><div class=\"track rev\" id=\"row2\">").append(ok.isEmpty() ? "" : figures(rev) + figures(rev)).append("</div></div>\n</section>\n\n");

        h.append("""
<section class="where" id="contact"><div class="wrap">
  <h2>Find us and book</h2>
  <div class="cols">
    <dl>
      <div><dt>Check-in and check-out</dt><dd>Both at 12 noon.</dd></div>
""");
        h.append("      <div><dt>Phone and WhatsApp</dt><dd><a href=\"").append(TEL).append("\">").append(esc(DISPLAY)).append("</a></dd></div>\n")
         .append("      <div><dt>Booking</dt><dd>Message or call us with your dates and the room you want. We will confirm.</dd></div>\n    </dl>\n    <div>\n")
         .append("      <p style=\"margin-bottom:18px\">Open the lodge location in Google Maps for directions.</p>\n      <div class=\"btns\">\n")
         .append("        <a class=\"btn dark\" href=\"https://maps.app.goo.gl/Z9vz9bHadsfyWSng8\" target=\"_blank\" rel=\"noopener\">Get directions</a>\n")
         .append("        <a class=\"btn line\" href=\"").append(TEL).append("\">Call now</a>\n")
         .append("        <a class=\"btn wa\" id=\"contactWa\" href=\"").append(bookWa).append("\">WhatsApp us</a>\n      </div>\n    </div>\n  </div>\n</div></section>\n\n");
        h.append("<footer><div class=\"wrap\"><span>The Velorr</span><span>").append(esc(DISPLAY)).append("</span></div></footer>\n")
         .append("<div class=\"floats\" id=\"floats\">\n  <a class=\"float call\" href=\"").append(TEL).append("\" aria-label=\"Call The Velorr\">Call</a>\n")
         .append("  <a class=\"float wa\" id=\"floatWa\" href=\"").append(bookWa).append("\" aria-label=\"Book on WhatsApp\">WhatsApp</a>\n</div>\n\n</body>\n</html>\n");
        return h.toString();
    }

    /** Port of section(r, i, extra). */
    private static String section(Room r, int i, int extra) {
        String price = r.p() > 0 ? "<div class=\"price\">₹" + inGroup(r.p()) + "<small>per night</small></div>" : "";
        String msg = r.p() > 0 ? "Hello The Velorr, I would like to book the " + r.n() + " (₹" + r.p() + " per night). Dates: "
                               : "Hello The Velorr, I would like to ask about parking.";
        String u = r.img() == null ? null : probe(r.img());
        String fig = u != null
                ? "<figure class=\"shot\" data-name=\"" + esc(r.n()) + "\"><img src=\"" + esc(u) + "\" alt=\"" + esc(r.n()) + "\" loading=\"lazy\"></figure>"
                : "<figure class=\"shot empty\" data-name=\"" + esc(r.n()) + "\"></figure>";
        return "<section class=\"room" + (i % 2 == 1 ? " flip" : "") + "\"><div class=\"wrap\">\n    " + fig + "\n" +
               "    <div class=\"info\">\n      <div class=\"no\">" + pad(i + 1) + " / " + pad(extra) + "</div>\n" +
               "      <h3>" + esc(r.n()) + "</h3><p class=\"desc\">" + esc(r.d()) + "</p>" + price + "\n" +
               "      <div class=\"acts\"><a class=\"btn wa\" href=\"" + esc(wa(msg)) + "\">" + (r.p() > 0 ? "Book this room" : "Ask on WhatsApp") + "</a>" +
               "<a class=\"btn call\" href=\"" + TEL + "\">Call</a></div>\n    </div></div></section>";
    }

    private static String figures(List<String> urls) {
        StringBuilder b = new StringBuilder();
        for (String u : urls) b.append("<figure><img src=\"").append(esc(u)).append("\" alt=\"The Velorr\" loading=\"lazy\"></figure>");
        return b.toString();
    }

    @GetMapping("/favicon.ico")
    public ResponseEntity<Void> favicon() { return ResponseEntity.notFound().build(); }

    /** Any other page goes back to the one-page site. */
    @GetMapping("/{path:^(?!image$|css$).*$}/**")
    public ResponseEntity<Void> fallback() {
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header(HttpHeaders.LOCATION, "/").build();
    }

}
