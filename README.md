# Leema Residency (pure-Java recreation)

A Spring Boot 3 (Java 17+, Maven) recreation of https://sensational-platypus-549c60.netlify.app,
a one-page site for the Leema Residency lodge. It has a video hero, check-in/out times, 7 rooms plus parking,
a marquee gallery, contact details and directions, and WhatsApp/call buttons.

**Everything is Java.** There are no templates and no `.html`, `.css`, `.js` or `.properties` sources, and the page
ships **no JavaScript**. Only the images and the hero video stay as binary files.

## Run
```bash
mvn spring-boot:run          # or: mvn package && java -jar target/leema-residency-1.0.0.jar
# open http://localhost:8081
```

## Routes
| Route | What it serves |
|---|---|
| `GET /`, `/index.html` | The full page, built in `PageController` |
| `GET /css/style.css` | The stylesheet, a Java string in `Css.java` |
| `GET /image/**` | Room photos and the hero MP4 (Range requests supported for video seeking) |
| any other path | 303 redirect to `/` |

## Code layout
- `LeemaApplication`: entry point. It sets the defaults (port 8081 and others) in Java.
- `web/Site`: phone and WhatsApp constants, room data, the gallery list, URL encoding and server-side image probing.
- `web/PageController`: builds the HTML.
- `web/Css`: the original CSS, plus a pure-CSS block that replaces the original JavaScript.
- `web/MediaConfig`: the `/image/**` resource handler.

## How the original JavaScript was replaced
- **Room and gallery building and image-extension probing:** done on the server at render time.
- **Solid nav after scrolling, hero zoom and text fade, mobile bottom bar, room reveal-on-scroll:** CSS scroll-driven
  animations (`animation-timeline: scroll()/view()`). They need Chrome/Edge 115+. Other browsers fall back to a static,
  fully visible layout.
- **"L" mark over the video watermark:** positioned with CSS container-query units instead of JS measurement.
- **Not ported:** the pointer-move tilt of the hero, which cannot be done without JS.

## Phone number
The original number (6362405907) was **replaced with 8296497253** everywhere. It is shown as `+91 82964 97253`, and as
`Call 82964 97253` in the nav, which keeps the original's compact nav style. Links use `tel:+918296497253` and
`https://wa.me/918296497253`.

## Screenshots
See `screenshots/`. The `orig-*` files are the original site, `java-*` files are this app, and `sbs-*` files are side by side.
Each set was taken at 1280x900 and 390x844.
