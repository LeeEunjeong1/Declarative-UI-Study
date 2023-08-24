//
//  ImageSlideView.swift
//  iOS
//
//  Created by 김지현 on 2023/07/28.
//

import SwiftUI

struct CarouselView: View {
    @State private var index: Int = 0
    @State private var selectedNum: Int = 0
    
	private let timer = Timer.publish(every: 3, on: .main, in: .common).autoconnect()
    private var data: [CarouselModel] = []
    
    init() {
        self.data = carouselData.map { $0 }
    }
	
	var body: some View {
        TabView(selection: $selectedNum) {
            ForEach(data, id: \.id) { data in
                ZStack(alignment: .bottom) {
                    AsyncImage(
                        url: URL(string: data.image),
                        content: { image in
                            image
                                .resizable()
                                .aspectRatio(contentMode: .fill)
                        }, placeholder: {
                            Color.gray
                        })
                    .tag(data.id)
                    Text(data.title)
                        .foregroundStyle(.white)
                        .padding(.vertical, 70)
                        .bold()
                    Text(data.text)
                        .foregroundStyle(.white)
                        .padding(.vertical, 40)
                        .bold()
                }
            }
        }
		.tabViewStyle(.page)
		.onReceive(timer, perform: { _ in
			withAnimation {
                index = index < data.count ? index + 1 : 0
                selectedNum = index
			}
		})
	}
}

struct CarouselView_Previews: PreviewProvider {
	static var previews: some View {
        CarouselView()
	}
}
