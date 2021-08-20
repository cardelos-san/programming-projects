import pygame
import sys
##import simpleGame


pygame.init()

WHITE = (255, 255, 255)

#Setting variables

WIDTH = 1000
HEIGHT = 600
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Caverun")
titleFont = pygame.font.SysFont("Arial, Times New Roman", 30)
mainScreenFont = pygame.font.SysFont("Arial, Times New Roman", 20)
gameTitle = titleFont.render("Caverun", True, WHITE )
mainScreenText = mainScreenFont.render("Press Space to continue", True, WHITE)
pygame.mixer.init()

pygame.mixer.music.load("MixedDream2.mp3")
pygame.mixer.music.play()

game_over = False

while not game_over:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        print(event)
        screen.blit(gameTitle, (WIDTH/2 - gameTitle.get_rect().width/2, HEIGHT/2 - 100))
        screen.blit(mainScreenText, (WIDTH/2 - gameTitle.get_rect().width/2, HEIGHT/2 - 50))
        pygame.display.update()

        
        
 

