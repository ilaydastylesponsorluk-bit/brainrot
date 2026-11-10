BRAINROT BLOCKS - Forge 1.20.1

DERLEME (en kolay yol):
1) Forge 1.20.1 MDK'yi indir (files.minecraftforge.net, 1.20.1 -> 47.x -> MDK).
2) MDK'nin icindeki gradlew, gradlew.bat ve gradle klasorunu bu klasore kopyala.
3) Java 17 kurulu olsun. Terminalde:  gradlew build
4) build/libs/brainrotblocks-1.0.0.jar dosyasini .minecraft/mods icine at.

KENDI GORSELLERINI KOYMAK:
src/main/resources/assets/brainrotblocks/textures/block/ icindeki PNG'leri
ayni isimle degistir. Arka plani SEFFAF (alpha) olan PNG kullan (ornegin 128x128 veya 256x256).

YENI KARAKTER EKLEMEK:
BrainrotBlocks.java icine bir registerBlock(...) satiri ekle, sonra su dosyalari ayni isimle cogalt:
blockstates, models/block, models/item, textures/block, lang, data/.../loot_tables/blocks
